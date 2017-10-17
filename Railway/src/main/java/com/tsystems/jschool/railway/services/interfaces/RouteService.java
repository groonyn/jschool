package com.tsystems.jschool.railway.services.interfaces;

import com.tsystems.jschool.railway.controllers.dto.NewRouteDto;
import com.tsystems.jschool.railway.controllers.dto.SaveRouteDto;
import com.tsystems.jschool.railway.persistence.Route;

import java.util.List;

public interface RouteService {
    NewRouteDto getNewRoute();
    void saveRoute(SaveRouteDto saveRouteDto);
    List<Route> getAllRoutes();
    Route findRouteById(Integer id);
}
