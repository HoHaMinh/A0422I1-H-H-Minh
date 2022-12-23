package com.example.Repository;

import com.example.Model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository{
    private final String SELECT_ALL ="SELECT * FROM customer_type;";
    @Override
    public List<CustomerType> showAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int typeId = resultSet.getInt("customer_type_id");
                String typeName = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(typeId,typeName);
                customerTypeList.add(customerType);
        }
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return customerTypeList;
    }
}
