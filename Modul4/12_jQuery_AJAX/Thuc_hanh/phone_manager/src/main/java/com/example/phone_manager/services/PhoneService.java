package com.example.phone_manager.services;

import com.example.phone_manager.entity.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhoneService {
    List<Phone> findAll();

    Phone findById(Long id);

    void save(Phone phone);

    void remove(Long id);

    Page<Phone> findAll(Pageable pageable);

    Page<Phone> findByInputText(String inputSearch, Pageable pageable);
}
