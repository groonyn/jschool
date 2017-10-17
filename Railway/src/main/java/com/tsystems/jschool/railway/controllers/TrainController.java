package com.tsystems.jschool.railway.controllers;

import com.tsystems.jschool.railway.persistence.Train;
import com.tsystems.jschool.railway.services.interfaces.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @RequestMapping(value = "trains", method = RequestMethod.GET)
    public String getAllTrains(Model model){
        model.addAttribute("train", new Train());
        model.addAttribute("listTrains", this.trainService.getAllTrains());
        return "trains";
    }

    @RequestMapping(value = "addTrain", method = RequestMethod.POST)
    public String addTrain(@ModelAttribute("train") Train train){
        trainService.addTrain(train);
        return "redirect:/trains";
    }

}
