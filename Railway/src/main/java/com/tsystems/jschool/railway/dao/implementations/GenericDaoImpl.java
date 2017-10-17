package com.tsystems.jschool.railway.dao.implementations;

import com.tsystems.jschool.railway.dao.interfaces.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager em;
    protected Class entityClass;

    public GenericDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class) genericSuperclass
                .getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
            em.persist(t);
            return t;
    }

    @Override
    public T update(T t) {
            em.merge(t);
            return t;
    }

    @Override
    public void delete(T t) {
            t = em.merge(t);
            em.remove(t);
    }

    @Override
    public T findById(Integer id) {
            return (T) em.find(entityClass, id);
    }

    @Override
    public List<T> findAll(){
            TypedQuery<T> query = em.createQuery("from " + entityClass.getName(), entityClass);
            return query.getResultList();
    }
}
