package Service;

import Model.CustomerType;
import Repository.CustomerTypeRepository;
import Repository.ICustomerTypeRepository;

import java.util.List;

public class CustomerTypeSerive implements ICustomerTypeSerivce{
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> showAll() {
        return customerTypeRepository.showAll();
    }
}
