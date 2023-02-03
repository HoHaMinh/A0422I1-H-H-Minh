package com.exercise.case_study.service.service;

import com.exercise.case_study.model.customer.Customer;
import com.exercise.case_study.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    void save (Service service);

    Page<Service> showAllWithPaging (Pageable pageable);
}
