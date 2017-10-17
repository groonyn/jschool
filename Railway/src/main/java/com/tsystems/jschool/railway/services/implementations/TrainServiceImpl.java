package com.tsystems.jschool.railway.services.implementations;

import com.tsystems.jschool.railway.dao.interfaces.TrainDao;
import com.tsystems.jschool.railway.persistence.Train;
import com.tsystems.jschool.railway.services.interfaces.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao trainDao;

    @Override
    @Transactional
    public Train addTrain(Train train) {
        return trainDao.create(train);
    }

    @Override
    public Train findTrainById(Integer id) {
        return trainDao.findById(id);
    }
    @Override
    @Transactional
    public Train findTrainByName(String trainName){
        return trainDao.findByName(trainName);
    }

    @Override
    @Transactional
    public List<Train> getAllTrains() {
        return trainDao.findAll();
    }
}
