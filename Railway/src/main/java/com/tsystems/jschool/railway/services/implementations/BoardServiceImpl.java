package com.tsystems.jschool.railway.services.implementations;

import com.tsystems.jschool.railway.controllers.dto.BoardByStationDto;
import com.tsystems.jschool.railway.controllers.dto.BoardDto;
import com.tsystems.jschool.railway.controllers.dto.SearchTripDto;
import com.tsystems.jschool.railway.controllers.dto.SuitableTripDto;
import com.tsystems.jschool.railway.dao.interfaces.*;
import com.tsystems.jschool.railway.persistence.*;
import com.tsystems.jschool.railway.services.interfaces.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao;
    private final RouteDao routeDao;
    private final TrainDao trainDao;
    private final WaypointDao waypointDao;
    private final TicketDao ticketDao;

    @Autowired
    public BoardServiceImpl(BoardDao boardDao, RouteDao routeDao, TrainDao trainDao, WaypointDao waypointDao, TicketDao ticketDao) {
        this.boardDao = boardDao;
        this.routeDao = routeDao;
        this.trainDao = trainDao;
        this.waypointDao = waypointDao;
        this.ticketDao = ticketDao;
    }

    @Override
    @Transactional
    public Board addBoard(Date dateTime, String trainName, String routeNumber) {
        Route route = routeDao.findByNumber(routeNumber);
        Train train = trainDao.findByName(trainName);
        Board board = new Board(dateTime, route, train);
        return boardDao.create(board);
    }

    @Override
    @Transactional
    public List<Board> getAllBoards(){
        return boardDao.findAll();
    }

    private BoardDto constructBoardDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardId(board.getId());
        StringBuilder routeWaypoints = new StringBuilder();
        boardDto.setTrainName(board.getTrain().getName());
        Route route = board.getRoute();
        List<Station> stations = new ArrayList<>();
        TreeSet<Waypoint> waypoints = new TreeSet<>(route.getWaypoints());
        for (Waypoint wp: waypoints){
            stations.add(wp.getStation());
        }
        for (Station station: stations){
            routeWaypoints.append(station.getName()).append(" ");
        }
        boardDto.setRouteWaypoints(routeWaypoints.toString().trim());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        boardDto.setDate(simpleDateFormat.format(board.getDateTime()));
        return boardDto;
    }

    @Override
    @Transactional
    public List<BoardDto> getAllBoardsDto(){
        List<BoardDto> boardDtos = new ArrayList<>();
        for(Board board : getAllBoards()) {
            boardDtos.add(constructBoardDto(board));
        }
        return boardDtos;
    }

    @Override
    @Transactional
    public SuitableTripDto constractSuitableTripDto(Board board, String stationFrom, String stationTo){
        SuitableTripDto suitableTripDto = new SuitableTripDto();
        if (board.getRoute().ifWaypointsSuitable(stationFrom, stationTo)){
            suitableTripDto.setBoardId(board.getId());
            suitableTripDto.setTrainName(board.getTrain().getName());
            Route route = board.getRoute();
            String routeName = route.findFirstWaypoint().getStation().getName()+" - "+route.findLastWaypoint().getStation().getName();
            suitableTripDto.setRoute(routeName);
            Waypoint wpFrom = waypointDao.findWaypointByStationNameAndRouteId(stationFrom, route.getId());
            Waypoint wpTo = waypointDao.findWaypointByStationNameAndRouteId(stationTo, route.getId());
            Integer from = wpFrom.getTravelStopTime();
            Integer to = wpTo.getTravelTime();
            suitableTripDto.setWaypointFromId(wpFrom.getId());
            suitableTripDto.setWaypointToId(wpTo.getId());
            suitableTripDto.setArrivalDateTime(wpFrom.arrivalDateTime(board.getDateTime()));
            suitableTripDto.setDepatureDateTime(wpTo.departureDateTime(board.getDateTime()));
            suitableTripDto.setStationFrom(stationFrom);
            suitableTripDto.setStationTo(stationTo);
            suitableTripDto.setPrice(new BigDecimal(Math.abs(to - from)).multiply(Ticket.FACTOR));
        }
        else suitableTripDto = null;
        return suitableTripDto;
    }

    @Override
    @Transactional
    public List<SuitableTripDto> findAllSuitableTrips(SearchTripDto searchTripDto){
        List<SuitableTripDto> suitableTripDtos = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date dateTimeFrom = dateFormat.parse(searchTripDto.getDateTimeFrom());
            Date dateTimeTo = dateFormat.parse(searchTripDto.getDateTimeTo());
            List<Board> suitableBoards = boardDao.findAllfindBoardsBetweenDates(dateTimeFrom, dateTimeTo);
            String stationFrom = searchTripDto.getStationFrom();
            String stationTo = searchTripDto.getStationTo();

            for(Board board : suitableBoards) {
                SuitableTripDto suitableTripDto = constractSuitableTripDto(board, stationFrom, stationTo);
                if (suitableTripDto != null){
                    suitableTripDtos.add(suitableTripDto);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return suitableTripDtos;
    }

    @Override
    @Transactional
    public Board findBoardById(Integer id) {
        return boardDao.findById(id);
    }

    @Override
    @Transactional
    public List<Passenger> findRegisteredPassengers(Board board){
        List<Passenger> passengers = new ArrayList<>();
        List<Ticket> tickets = ticketDao.findTicketsByBoard(board);
        for (Ticket ticket: tickets){
            passengers.add(ticket.getPassenger());
        }
        return passengers;
    }

    @Override
    @Transactional
    public List<BoardByStationDto> getAllBoardByStationDto(String stationName){
        List<BoardByStationDto> boardByStationDtos = new ArrayList<>();
        List<Waypoint> waypoints = waypointDao.findWaypointByStationName(stationName);
        Set<Route> routes = new HashSet<>();
        for (Waypoint wp: waypoints){
            routes.add(wp.getRoute());
        }
        Set<Board> boards = new HashSet<>();
        for (Route route: routes){
            boards.addAll(route.getBoards());
        }
       // List<Board> boards = boardDao.findBoardByStationName(stationName);
        for(Board board : boards) {
            boardByStationDtos.add(constructBoardByStationDto(board, stationName));
        }
        return boardByStationDtos;
    }
    private BoardByStationDto constructBoardByStationDto(Board board, String stationName){
        BoardByStationDto boardByStationDto = new BoardByStationDto();
        boardByStationDto.setTrainName(board.getTrain().getName());
        Route route = board.getRoute();
        String routeName = route.findFirstWaypoint().getStation().getName()+" - "+route.findLastWaypoint().getStation().getName();
        boardByStationDto.setRoute(routeName);
        Waypoint wp = waypointDao.findWaypointByStationNameAndRouteId(stationName, route.getId());
        boardByStationDto.setArrivaDatelTime(wp.arrivalDateTime(board.getDateTime()));
        boardByStationDto.setDepatureDateTime(wp.departureDateTime(board.getDateTime()));
        return boardByStationDto;
    }
}
