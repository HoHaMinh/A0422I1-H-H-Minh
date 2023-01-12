package com.practice.phone_management.repository;

import com.practice.phone_management.model.SmartPhone;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISmartphoneRepository extends PagingAndSortingRepository<SmartPhone,Long> {
}
