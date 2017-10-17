package com.tsystems.jschool.railway.services.interfaces;

import com.tsystems.jschool.railway.controllers.dto.BoardByStationDto;
import com.tsystems.jschool.railway.controllers.dto.BoardDto;
import com.tsystems.jschool.railway.controllers.dto.SearchTripDto;
import com.tsystems.jschool.railway.controllers.dto.SuitableTripDto;
import com.tsystems.jschool.railway.persistence.Board;
import com.tsystems.jschool.railway.persistence.Passenger;
import com.tsystems.jschool.railway.persistence.Train;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface BoardService {
    Board addBoard(Date dateTime, String trainName, String routeNumber);
    List<Board> getAllBoards();
    List<BoardDto> getAllBoardsDto();
    List<SuitableTripDto> findAllSuitableTrips(SearchTripDto searchTripDto);
    Board findBoardById(Integer id);
    SuitableTripDto constractSuitableTripDto(Board board, String stationFrom, String stationTo);
    List<Passenger> findRegisteredPassengers(Board board);
    List<BoardByStationDto> getAllBoardByStationDto(String stationName);
}
