package com.example.case_study.service;

import com.example.case_study.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();

    Position findById(Long id);

    void save(Position position);

    void remove(Long id);
}
