package com.tsystems.jschool.railway.services.interfaces;

import com.tsystems.jschool.railway.persistence.User;

public interface UserService {
    User findUserById(Integer id);
}
