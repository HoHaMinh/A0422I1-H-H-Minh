package com.exercise.case_study.service.service;

import com.exercise.case_study.model.customer.Customer;
import com.exercise.case_study.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    void save (Service service);

    Page<Service> showAllWithPaging (Pageable pageable);

    List<Service> showAll();
}
