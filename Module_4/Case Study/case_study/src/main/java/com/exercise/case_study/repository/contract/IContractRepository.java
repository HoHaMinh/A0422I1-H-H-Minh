package com.exercise.case_study.repository.contract;

import com.exercise.case_study.model.contract.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IContractRepository extends PagingAndSortingRepository<Contract,Integer> {
}
