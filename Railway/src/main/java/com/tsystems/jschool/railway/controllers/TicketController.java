package com.tsystems.jschool.railway.controllers;

import com.tsystems.jschool.railway.controllers.dto.SuitableTripDto;
import com.tsystems.jschool.railway.persistence.Board;
import com.tsystems.jschool.railway.persistence.Passenger;
import com.tsystems.jschool.railway.persistence.User;
import com.tsystems.jschool.railway.persistence.Waypoint;
import com.tsystems.jschool.railway.services.interfaces.BoardService;
import com.tsystems.jschool.railway.services.interfaces.TicketService;
import com.tsystems.jschool.railway.services.interfaces.UserService;
import com.tsystems.jschool.railway.services.interfaces.WaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TicketController {
    private final BoardService boardService;
    private final WaypointService waypointService;
    private final TicketService ticketService;
    private final UserService userService;

    @Autowired
    public TicketController(BoardService boardService, WaypointService waypointService, TicketService ticketService, UserService userService) {
        this.boardService = boardService;
        this.waypointService = waypointService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @RequestMapping("buyticket/{boardid}/{wpfromid}/{wptoid}")
    public String buyTicketPage(@PathVariable("boardid") int boardId, @PathVariable("wpfromid") int wpFromId,
                           @PathVariable("wptoid") int wpToId, Model model){
        Board board = boardService.findBoardById(boardId);
        Waypoint wpFrom = waypointService.findWaypointById(wpFromId);
        Waypoint wpTo = waypointService.findWaypointById(wpToId);
        SuitableTripDto trip = boardService.constractSuitableTripDto(board,wpFrom.getStation().getName(), wpTo.getStation().getName());
        model.addAttribute("trip", trip);
        model.addAttribute("board", board);
        model.addAttribute("wpFrom", wpFrom);
        model.addAttribute("wpTo", wpTo);
        return "buyticket";
    }

    @RequestMapping(value = "addTicket", method = RequestMethod.POST)
    public String buyTicket(Model model,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String birthdate,
                            @RequestParam String passport,
                            @RequestParam int boardId,
                            @RequestParam int wpFromId, @RequestParam int wpToId, @RequestParam String dateTime){
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date birthdateDate = dateFormat.parse(birthdate);
            DateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date startDate = dateTimeFormat.parse(dateTime);
            User user = userService.findUserById(1);
            Passenger passenger = new Passenger(firstName, lastName, birthdateDate, passport, user);
            ticketService.buyTicket(passenger, boardId, wpFromId, wpToId, startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "success";
    }
}
