package com.codegym.module2.Service.Impl;

import com.codegym.module2.Model.Position;
import com.codegym.module2.Repository.PositionRepository;
import com.codegym.module2.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findByid(int id) {
        return positionRepository.findById(id).get();
    }



}
