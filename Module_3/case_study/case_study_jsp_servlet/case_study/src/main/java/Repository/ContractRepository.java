package Repository;

import Model.Contract;

import java.util.List;

public class ContractRepository implements IContractRepository{
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
