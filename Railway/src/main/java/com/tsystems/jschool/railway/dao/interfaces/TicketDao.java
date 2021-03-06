package com.tsystems.jschool.railway.dao.interfaces;

import com.tsystems.jschool.railway.persistence.Board;
import com.tsystems.jschool.railway.persistence.Ticket;

import java.util.List;

public interface TicketDao extends GenericDao<Ticket> {
    List<Ticket> findTicketsByBoard(Board board);
}
