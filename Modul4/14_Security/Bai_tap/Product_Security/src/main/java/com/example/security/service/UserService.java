package com.example.security.service;

import com.example.security.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService  {
    User findUserByUserName(String username);
}
