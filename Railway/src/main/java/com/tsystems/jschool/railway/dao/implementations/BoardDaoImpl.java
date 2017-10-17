package com.tsystems.jschool.railway.dao.implementations;

import com.tsystems.jschool.railway.dao.interfaces.BoardDao;
import com.tsystems.jschool.railway.persistence.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class BoardDaoImpl extends GenericDaoImpl<Board> implements BoardDao {

    @Override
    public List<Board> findAllfindBoardsBetweenDates(Date dateTimeFrom, Date dateTimeTo) {
        TypedQuery<Board> query = em.createNamedQuery("Board.findBoardsBetweenDates", Board.class);
        query.setParameter("dateTimeFrom", dateTimeFrom);
        query.setParameter("dateTimeTo", dateTimeTo);
        return query.getResultList();
    }

    @Override
    public Board findBoardByRouteNumber(String routeNumber){
        return em.createNamedQuery("Board.findBoardByRouteNumber", Board.class)
                .setParameter("routeNumber", routeNumber)
                .getSingleResult();
    }

    @Override
    public List<Board> findBoardByStationName(String stationName){
        TypedQuery<Board> query = em.createNamedQuery("Board.findBoardByStationName", Board.class);
        query.setParameter("stationName", stationName);
        return query.getResultList();
    }
}
