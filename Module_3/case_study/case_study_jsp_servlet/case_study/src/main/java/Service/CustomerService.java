package Service;

import Model.Customer;
import Repository.CustomerRepository;
import Repository.ICustomerRepository;
import Validate.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService{
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> showAll() {
        return customerRepository.showAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Map<String,String> add(Customer customer) {
        Map<String, String> errorMap = new HashMap<>();
        if ("".equals(customer.getCustomerName())){
            errorMap.put("name","Name can not be blank");
        }
        if ("".equals(customer.isCustomerGender())){
            errorMap.put("name","Name can not be blank");
        }
        if (!Validator.isValidDate(customer.getCustomerBirthday())) {
            errorMap.put("birthday","Input birthday is wrong");
        }
        if ("".equals(customer.getCustomerIdCard())){
            errorMap.put("idCard","idCard can not be blank");
        }
        if ("".equals(customer.getCustomerPhone())){
            errorMap.put("phone","phone can not be blank");
        }
        if ("".equals(customer.getCustomerEmail())){
            errorMap.put("email","Email can not be blank");
        }
        else if(!Validator.checkEmail(customer.getCustomerEmail())){
            errorMap.put("email","Email is wrong format");
        }
        if (errorMap.isEmpty()){
            customerRepository.add(customer);
        }
        return errorMap;
    }

    @Override
    public boolean update(Customer customer) {
        customerRepository.update(customer);
        return true;
    }

    @Override
    public boolean delete(int id) {
        customerRepository.delete(id);
        return true;
    }

    @Override
    public List<Customer> search(String searchName, String searchAddress, int searchTypeId) {
        return customerRepository.search(searchName,searchAddress,searchTypeId);
    }
}
