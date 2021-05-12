package com.form_input.services;

import com.form_input.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
}
