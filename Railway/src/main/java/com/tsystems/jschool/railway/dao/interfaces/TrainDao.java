package com.tsystems.jschool.railway.dao.interfaces;

import com.tsystems.jschool.railway.persistence.Train;

public interface TrainDao extends GenericDao<Train> {
    Train findByName(String name);
}
