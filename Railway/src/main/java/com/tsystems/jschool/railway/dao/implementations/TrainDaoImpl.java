package com.tsystems.jschool.railway.dao.implementations;

import com.tsystems.jschool.railway.dao.interfaces.TrainDao;
import com.tsystems.jschool.railway.persistence.Train;
import org.springframework.stereotype.Repository;

@Repository
public class TrainDaoImpl extends GenericDaoImpl<Train> implements TrainDao {

    public Train findByName(String trainName) {
        return em.createNamedQuery("Train.findTrainByName", Train.class)
                .setParameter("trainName", trainName)
                .getSingleResult();
    }
}
