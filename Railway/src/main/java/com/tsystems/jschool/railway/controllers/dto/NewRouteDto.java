package com.tsystems.jschool.railway.controllers.dto;

import com.tsystems.jschool.railway.persistence.Station;
import com.tsystems.jschool.railway.persistence.Train;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NewRouteDto {

    private List<Station> stations;

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
