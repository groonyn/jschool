package com.tsystems.jschool.railway.services.interfaces;

import com.tsystems.jschool.railway.persistence.Waypoint;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WaypointService {
    Waypoint findWaypointById(Integer id);
    List<Waypoint> findWaypointByStationName(String stationName);
}
