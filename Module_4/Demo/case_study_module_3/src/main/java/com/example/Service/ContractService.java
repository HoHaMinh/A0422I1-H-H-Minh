package com.example.Service;

import com.example.Repository.ContractRepository;
import com.example.Repository.IContractRepository;
import com.example.Model.Contract;

import java.util.List;

public class ContractService implements IContractService{
    private IContractRepository contractRepository = new ContractRepository();
    @Override
    public List<Contract> showAll() {
        return null;
    }

    @Override
    public List<Contract> findById(int id) {
        return null;
    }

    @Override
    public boolean add(Contract contract) {
        return false;
    }

    @Override
    public boolean edit(Contract contract) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
