package com.codegym.module2.Service;

import com.codegym.module2.Model.Gender;

public interface GenderService {
    Iterable<Gender> findAll();

    Gender findByid(int id);
}
