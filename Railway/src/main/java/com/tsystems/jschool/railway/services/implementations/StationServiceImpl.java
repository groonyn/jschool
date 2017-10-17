package com.tsystems.jschool.railway.services.implementations;

import com.tsystems.jschool.railway.dao.interfaces.StationDao;
import com.tsystems.jschool.railway.persistence.Station;
import com.tsystems.jschool.railway.services.interfaces.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDao stationDao;

    @Override
    @Transactional
    public Station addStation(String stationName) {
        Station station = new Station(stationName);
        return stationDao.create(station);
    }

    @Override
    @Transactional
    public List<Station> getAllStations() {
        return stationDao.findAll();
    }

    @Override
    @Transactional
    public Station getStationById(Integer stationId) {
        return stationDao.findById(stationId);
    }
}
