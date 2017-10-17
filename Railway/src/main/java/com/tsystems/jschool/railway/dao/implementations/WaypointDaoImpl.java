package com.tsystems.jschool.railway.dao.implementations;

import com.tsystems.jschool.railway.dao.interfaces.WaypointDao;
import com.tsystems.jschool.railway.persistence.Waypoint;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WaypointDaoImpl extends GenericDaoImpl<Waypoint> implements WaypointDao {
    @Override
    public Waypoint findWaypointByStationNameAndRouteId(String stationName, int routeId) {
        return em.createNamedQuery("Waypoint.findWaypointByStationNameAndRouteId", Waypoint.class)
                .setParameter("stationName", stationName)
                .setParameter("routeId", routeId)
                .getSingleResult();
    }
    @Override
    public List<Waypoint> findWaypointByStationName(String stationName){
        return em.createNamedQuery("Waypoint.findWaypointByStationName", Waypoint.class)
                .setParameter("stationName", stationName)
                .getResultList();
    }
}
