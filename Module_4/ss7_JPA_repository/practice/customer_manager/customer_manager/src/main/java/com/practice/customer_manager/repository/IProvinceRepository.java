package com.practice.customer_manager.repository;

import com.practice.customer_manager.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends PagingAndSortingRepository<Province,Integer> {
}
