package com.tsystems.jschool.railway.services.implementations;

import com.tsystems.jschool.railway.dao.interfaces.WaypointDao;
import com.tsystems.jschool.railway.persistence.Waypoint;
import com.tsystems.jschool.railway.services.interfaces.WaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WaypointServiceImpl implements WaypointService {
    private final WaypointDao waypointDao;

    @Autowired
    public WaypointServiceImpl(WaypointDao waypointDao) {
        this.waypointDao = waypointDao;
    }

    @Override
    @Transactional
    public Waypoint findWaypointById(Integer id) {
        return waypointDao.findById(id);
    }

    @Override
    @Transactional
    public List<Waypoint> findWaypointByStationName(String stationName){
        return waypointDao.findWaypointByStationName(stationName);
    }
}
