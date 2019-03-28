package com.codegym.module2.Service.Impl;

import com.codegym.module2.Model.Gender;
import com.codegym.module2.Repository.GenderRepository;
import com.codegym.module2.Service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public Iterable<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Gender findByid(int id) {
        return genderRepository.findById(id).get();
    }


}
