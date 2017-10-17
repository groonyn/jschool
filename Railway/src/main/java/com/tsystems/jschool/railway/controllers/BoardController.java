package com.tsystems.jschool.railway.controllers;

import com.tsystems.jschool.railway.controllers.dto.BoardByStationDto;
import com.tsystems.jschool.railway.controllers.dto.BoardDto;
import com.tsystems.jschool.railway.controllers.dto.SearchTripDto;
import com.tsystems.jschool.railway.persistence.Board;
import com.tsystems.jschool.railway.persistence.Passenger;
import com.tsystems.jschool.railway.persistence.Station;
import com.tsystems.jschool.railway.services.interfaces.BoardService;
import com.tsystems.jschool.railway.services.interfaces.StationService;
import com.tsystems.jschool.railway.services.interfaces.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;
    private final StationService stationService;

    @Autowired
    public BoardController(BoardService boardService, StationService stationService) {
        this.boardService = boardService;
        this.stationService = stationService;
    }

    @RequestMapping(value = "/addTrainRoute", method = RequestMethod.POST)
    public String addBoard(@RequestParam("route") String route, @RequestParam("trainName") String trainName,
                           @RequestParam("date") String date){
        Date boardDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            boardDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boardService.addBoard(boardDate, trainName, route);
        return "redirect:/allTrainsRoutes";
    }

    @RequestMapping(value = "/allTrainsRoutes", method = RequestMethod.GET)
    public String getAllTrainsAndRoutes(Model model){
        model.addAttribute("board", new BoardDto());
        model.addAttribute("listBoards", this.boardService.getAllBoardsDto());
        return "alltrainsroutes";
    }

    @RequestMapping(value = "searchTrip", method = RequestMethod.GET)
    public String searchTrips(Model model){
        model.addAttribute("searchTripDto", new SearchTripDto());
        model.addAttribute("station", new Station());
        model.addAttribute("allStations", this.stationService.getAllStations());
        return "test";
    }

    @RequestMapping(value = "findTrip", method = RequestMethod.POST)
    public String findTrips(@ModelAttribute("searchTripDto") SearchTripDto searchTripDto, Model model){
        model.addAttribute("suitableTrips", boardService.findAllSuitableTrips(searchTripDto));
        return "suitabletrips";
    }
    @RequestMapping("registredpassengers/{id}")
    public String findRegistredPassengers(@PathVariable("id") int id, Model model){
        Board board = boardService.findBoardById(id);
        List<Passenger> passengers = boardService.findRegisteredPassengers(board);
        model.addAttribute("allPassengers", passengers);
        return "registredpassengers";
    }

    @RequestMapping(value = "boardByStation", method = RequestMethod.GET)
    public String getBoardByStation(Model model){
        model.addAttribute("allStations", stationService.getAllStations());
        return "boardbystation";
    }

    @RequestMapping(value = "showBoardByStation", method = RequestMethod.POST)
    public String showBoardByStation(@RequestParam String stationName, Model model){
        List<BoardByStationDto> boardByStationDtos = boardService.getAllBoardByStationDto(stationName);
        model.addAttribute("allBoards", boardByStationDtos);
        return "showboard";
    }
}
