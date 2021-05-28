package com.example.case_study.repository;

import com.example.case_study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    @Query("SELECT u.id FROM User u WHERE u.username = ?1")
    Long getUserIdByUserName(String username);

    Boolean existsUsersByUserName(String username);
}
