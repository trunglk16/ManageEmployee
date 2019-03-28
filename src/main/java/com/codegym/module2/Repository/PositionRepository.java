package com.codegym.module2.Repository;

import com.codegym.module2.Model.Position;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PositionRepository extends PagingAndSortingRepository<Position,Integer> {
}
