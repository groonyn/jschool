package com.tsystems.jschool.railway.dao.implementations;

import com.tsystems.jschool.railway.dao.interfaces.UserDao;
import com.tsystems.jschool.railway.persistence.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
}
