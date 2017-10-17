package com.tsystems.jschool.railway.services.implementations;

import com.tsystems.jschool.railway.controllers.dto.NewRouteDto;
import com.tsystems.jschool.railway.controllers.dto.SaveRouteDto;
import com.tsystems.jschool.railway.dao.interfaces.*;
import com.tsystems.jschool.railway.persistence.*;
import com.tsystems.jschool.railway.services.interfaces.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private StationDao stationDao;
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private RouteDao routeDao;
    @Autowired
    private WaypointDao waypointDao;
    @Autowired
    private BoardDao boardDao;

    @Transactional
    public NewRouteDto getNewRoute(){
        List<Station> stations = stationDao.findAll();
        NewRouteDto newRouteDto = new NewRouteDto();
        newRouteDto.setStations(stations);
        return newRouteDto;
    }

    @Override
    @Transactional
    public void saveRoute(SaveRouteDto saveRouteDto) {
        Route route = routeDao.create(new Route(saveRouteDto.getRouteNumber()));
        for (int i = 0; i < saveRouteDto.getWaypointStations().size(); i++) {
            Station station = stationDao.findByName(saveRouteDto.getWaypointStations().get(i));
            Integer travelTime = saveRouteDto.getWaypointTravellTime().get(i);
            Integer travelStopTime = saveRouteDto.getWaypointTravelStopTime().get(i);
            waypointDao.create(new Waypoint(station, route, travelTime, travelStopTime, i));
        }
    }

    @Override
    @Transactional
    public List<Route> getAllRoutes(){
        return routeDao.findAll();
    }

    @Override
    @Transactional
    public Route findRouteById(Integer id){
        return routeDao.findById(id);
    }
}
