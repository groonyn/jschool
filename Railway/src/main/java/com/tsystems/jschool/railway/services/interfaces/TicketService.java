package com.tsystems.jschool.railway.services.interfaces;

import com.tsystems.jschool.railway.persistence.Passenger;
import com.tsystems.jschool.railway.persistence.Ticket;

import java.util.Date;

public interface TicketService {
    Ticket buyTicket(Passenger passenger, int boardId, int wpFromId, int wpToId, Date startDate);
}
