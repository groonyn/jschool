package com.tsystems.jschool.railway.dao.implementations;

import com.tsystems.jschool.railway.dao.interfaces.RouteDao;
import com.tsystems.jschool.railway.persistence.Route;
import org.springframework.stereotype.Repository;

@Repository
public class RouteDaoImpl extends GenericDaoImpl<Route> implements RouteDao {
    public Route findByNumber(String routeNumber) {
        return em.createNamedQuery("Route.findRouteByNumber", Route.class)
                .setParameter("routeNumber", routeNumber)
                .getSingleResult();
    }

}
