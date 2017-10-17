package com.tsystems.jschool.railway.services.implementations;

import com.tsystems.jschool.railway.dao.interfaces.BoardDao;
import com.tsystems.jschool.railway.dao.interfaces.PassengerDao;
import com.tsystems.jschool.railway.dao.interfaces.TicketDao;
import com.tsystems.jschool.railway.dao.interfaces.WaypointDao;
import com.tsystems.jschool.railway.persistence.*;
import com.tsystems.jschool.railway.services.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketDao ticketDao;
    private final BoardDao boardDao;
    private final WaypointDao waypointDao;
    private final PassengerDao passengerDao;

    @Autowired
    public TicketServiceImpl(TicketDao ticketDao, BoardDao boardDao, WaypointDao waypointDao, PassengerDao passengerDao) {
        this.ticketDao = ticketDao;
        this.boardDao = boardDao;
        this.waypointDao = waypointDao;
        this.passengerDao = passengerDao;
    }

    @Override
    @Transactional
    public Ticket buyTicket(Passenger passenger, int boardId, int wpFromId, int wpToId, Date startDate){
        Board board = boardDao.findById(boardId);
        Waypoint wpFrom = waypointDao.findById(wpFromId);
        Waypoint wpTo = waypointDao.findById(wpToId);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(startDate);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        long diff = c1.getTimeInMillis() - c2.getTimeInMillis();
        if (diff / 60000 < 10) throw new RuntimeException("too late to buy ticket");
        Train train = board.getTrain();
        if (train.getCapacity() <= board.getTickets().size()) throw new RuntimeException("the tickets are run out");
        List<Ticket> tickets = ticketDao.findTicketsByBoard(board);
        for (Ticket ticket : tickets) {
            if (ticket.getPassenger().equals(passenger)) throw new RuntimeException("the passenger is already registred on this train");
        }
       // passengerDao.create(passenger);
        Ticket ticket = new Ticket();
        ticket.setPassenger(passengerDao.create(passenger));
        ticket.setBoard(board);
        ticket.setWaypointFrom(wpFrom);
        ticket.setWaypointTo(wpTo);
        ticket.setPrice();
        return ticketDao.create(ticket);
    }
}
