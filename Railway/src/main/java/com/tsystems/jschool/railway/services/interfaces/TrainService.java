package com.tsystems.jschool.railway.services.interfaces;

import com.tsystems.jschool.railway.persistence.Train;

import java.util.List;

public interface TrainService {

    Train addTrain(Train train);
    Train findTrainById(Integer id);
    List<Train> getAllTrains();
    Train findTrainByName(String trainName);
}
