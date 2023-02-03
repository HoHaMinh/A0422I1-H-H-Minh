package com.exercise.case_study.service.impl.contract;

import com.exercise.case_study.model.contract.Contract;
import com.exercise.case_study.repository.contract.IContractRepository;
import com.exercise.case_study.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
