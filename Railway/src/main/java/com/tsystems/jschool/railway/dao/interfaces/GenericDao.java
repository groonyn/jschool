package com.tsystems.jschool.railway.dao.interfaces;

import java.util.List;

public interface GenericDao<T> {

    T create(T t);

    T update(T t);

    void delete(T t);

    T findById(Integer id);

    List<T> findAll();
}
