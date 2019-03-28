package com.codegym.module2.Service.Impl;

import com.codegym.module2.Model.Employee;
import com.codegym.module2.Repository.EmployeeRepository;
import com.codegym.module2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void save(Employee note) {
        employeeRepository.save(note);
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAllByNameContainingOrIndContaining(String string, String text, Pageable pageable) {
        return employeeRepository.findAllByNameContainingOrIndContaining(string,text,pageable);
    }
}
