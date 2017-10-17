package com.tsystems.jschool.railway.services.interfaces;

import com.tsystems.jschool.railway.persistence.Station;

import java.util.List;

public interface StationService {

    Station addStation(String name);

    List<Station> getAllStations();

    Station getStationById(Integer id);
}
