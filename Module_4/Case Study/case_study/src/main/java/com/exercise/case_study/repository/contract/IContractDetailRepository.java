package com.exercise.case_study.repository.contract;

import com.exercise.case_study.model.contract.ContractDetail;
import org.springframework.data.repository.CrudRepository;

public interface IContractDetailRepository extends CrudRepository<ContractDetail,Integer> {
}
