package com.codegym.module2.Repository;

import com.codegym.module2.Model.Gender;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GenderRepository extends PagingAndSortingRepository<Gender,Integer> {
}
