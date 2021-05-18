package com.example.phone_manager.repositories;

import com.example.phone_manager.entity.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {
    @Query("select s from Phone s where s.name =:input ")
    Page<Phone> findByName(@Param("input") String name, Pageable pageable);
}
