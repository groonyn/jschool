package com.tsystems.jschool.railway.controllers;

import com.tsystems.jschool.railway.persistence.Station;
import com.tsystems.jschool.railway.services.interfaces.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StationController {

    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @RequestMapping(value = "/stations", method = RequestMethod.GET)
    public String getAllStations(Model model){
        model.addAttribute("station", new Station());
        model.addAttribute("listStations", this.stationService.getAllStations());
        return "stations";
    }

    @RequestMapping(value = "addStation", method = RequestMethod.POST)
    public String addStation(@RequestParam String stationName){
        stationService.addStation(stationName);
        return "redirect:/stations";
    }

}
