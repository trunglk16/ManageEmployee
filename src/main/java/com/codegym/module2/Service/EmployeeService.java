package com.codegym.module2.Service;

import com.codegym.module2.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {


    Page<Employee> findAll(Pageable pageable);
    Employee findById(int id) ;

    void remove(int id);

    void save(Employee employee);

    Page<Employee> findAllByNameContainingOrIndContaining(String string, String text, Pageable pageable);


}
