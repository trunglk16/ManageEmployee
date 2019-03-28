package com.codegym.module2.Repository;

import com.codegym.module2.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    Page<Employee> findAllByNameContainingOrIndContaining(String string, String text, Pageable pageable);
}
