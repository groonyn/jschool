package com.tsystems.jschool.railway.controllers;

import com.tsystems.jschool.railway.controllers.dto.NewRouteDto;
import com.tsystems.jschool.railway.controllers.dto.SaveRouteDto;
import com.tsystems.jschool.railway.persistence.Route;
import com.tsystems.jschool.railway.persistence.Train;
import com.tsystems.jschool.railway.services.interfaces.RouteService;
import com.tsystems.jschool.railway.services.interfaces.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RouteController {

    private final RouteService routeService;
    private final TrainService trainService;

    @Autowired
    public RouteController(RouteService routeService, TrainService trainService) {
        this.routeService = routeService;
        this.trainService = trainService;
    }

    @RequestMapping("addroute/{id}")
    public String addRoute(@PathVariable("id") int id, Model model){
        Train train = trainService.findTrainById(id);
        model.addAttribute("train", train);
        model.addAttribute("allRoutes", routeService.getAllRoutes());
        return "addroute";
    }

    @RequestMapping(value = "allRoutes", method = RequestMethod.GET)
    public String getAllRoutes(Model model){
        model.addAttribute("route", new Route());
        model.addAttribute("allRoutes", routeService.getAllRoutes());
        return "routes";
    }

    @RequestMapping(value = "createRoute", method = RequestMethod.GET)
    public String createRoute(Model model){
        NewRouteDto newRouteDto = routeService.getNewRoute();
        model.addAttribute("allStations", newRouteDto.getStations());
        return "newroute";
    }

    @RequestMapping(value = "saveroute", method = RequestMethod.POST)
    public String saveRoute(@RequestParam("json") String json) {
        SaveRouteDto saveRouteDto = new SaveRouteDto();
        List<String> waypointStations = new ArrayList<>();
        List<Integer> waypointTravellTime=new ArrayList<>();
        List<Integer> waypointTravelStopTime=new ArrayList<>();

        JSONObject obj = new JSONObject(json);
        saveRouteDto.setRouteNumber(obj.getString("routeNumber"));
        JSONArray waypoints = obj.getJSONArray("waypoints");

        Integer prevTravelStopTime = -1;

        for (int i = 0; i < waypoints.length(); i++) {
            String station = waypoints.getJSONObject(i).getString("station");
            String travelTimeStr = waypoints.getJSONObject(i).getString("travelTime");
            if (travelTimeStr.trim().length() == 0) travelTimeStr = "0";
            String stopTimeStr = waypoints.getJSONObject(i).getString("stopTime");
            if (stopTimeStr.trim().length() == 0) stopTimeStr = "0";
            Integer travelTime = Integer.parseInt(travelTimeStr);
            Integer travelStopTime = Integer.parseInt(stopTimeStr) + travelTime;

            prevTravelStopTime = travelStopTime;
            waypointStations.add(station);
            waypointTravellTime.add(travelTime);
            waypointTravelStopTime.add(travelStopTime);
        }

        saveRouteDto.setWaypointStations(waypointStations);
        saveRouteDto.setWaypointTravellTime(waypointTravellTime);
        saveRouteDto.setWaypointTravelStopTime(waypointTravelStopTime);

        routeService.saveRoute(saveRouteDto);
        return "success";
    }
}
