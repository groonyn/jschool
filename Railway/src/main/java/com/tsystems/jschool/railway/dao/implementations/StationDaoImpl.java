package com.tsystems.jschool.railway.dao.implementations;

import com.tsystems.jschool.railway.dao.interfaces.StationDao;
import com.tsystems.jschool.railway.persistence.Station;
import org.springframework.stereotype.Repository;

@Repository
public class StationDaoImpl extends GenericDaoImpl<Station> implements StationDao {

    public Station findByName(String stationName) {
        return em.createNamedQuery("Station.findStationByName", Station.class)
                .setParameter("stationName", stationName)
                .getSingleResult();
    }
}
