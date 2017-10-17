package com.tsystems.jschool.railway.dao.interfaces;

import com.tsystems.jschool.railway.persistence.Board;

import java.util.Date;
import java.util.List;

public interface BoardDao extends GenericDao<Board> {
    List<Board> findAllfindBoardsBetweenDates(Date dateTimeFrom, Date dateTimeTo);
    Board findBoardByRouteNumber(String routeNumber);
    List<Board> findBoardByStationName(String stationName);
}
