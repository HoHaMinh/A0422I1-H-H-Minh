package com.exercise.case_study.service.impl.contract;

import com.exercise.case_study.model.contract.ContractDetail;
import com.exercise.case_study.repository.contract.IContractDetailRepository;
import com.exercise.case_study.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
