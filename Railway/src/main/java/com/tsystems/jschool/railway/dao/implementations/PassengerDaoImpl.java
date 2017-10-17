package com.tsystems.jschool.railway.dao.implementations;

import com.tsystems.jschool.railway.dao.interfaces.PassengerDao;
import com.tsystems.jschool.railway.persistence.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerDaoImpl extends GenericDaoImpl<Passenger> implements PassengerDao {
}
