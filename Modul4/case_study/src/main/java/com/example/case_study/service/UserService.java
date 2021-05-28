package com.example.case_study.service;

import com.example.case_study.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    User save(User user);

//    Optional<User> findById(Integer integer);

    boolean existsById(Long longer);

    List<User> findAll();

//    Iterable<User> findAllById(Iterable<Integer> iterable);

//    long count();

//    void deleteById(Integer integer);

//    void delete(User user);

//    void deleteAll(Iterable<? extends User> iterable);

//    void deleteAll();

    UserDetails loadUserByUsername(String username);

    @Query("SELECT u.id FROM User u WHERE u.username = ?1")
    Long getUserIdByUserName(String username);

//    Boolean checkExistUser(String username);
}
