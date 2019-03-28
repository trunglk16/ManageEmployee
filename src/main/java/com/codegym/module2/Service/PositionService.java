package com.codegym.module2.Service;


import com.codegym.module2.Model.Position;

public interface PositionService {
    Iterable<Position> findAll();

    Position findByid(int id);

}
