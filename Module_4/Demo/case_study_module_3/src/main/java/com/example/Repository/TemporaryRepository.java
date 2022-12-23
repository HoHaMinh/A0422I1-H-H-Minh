package com.example.Repository;

import com.example.Model.Temporary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TemporaryRepository implements ITemporaryRepository{
    private final String SELECT_ALL = "select * from temporary;";
    private final String SEARCH_NAME_SERVICE ="select * from temporary where customer_name like ? and attach_service_name like ?;";
    @Override
    public List<Temporary> showAll() {
        List<Temporary> temporaryList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");// columnLable : tên trường trong database// get theo kiểu dữ liệu của Java
                String name = resultSet.getString("customer_name");
                int idContract = resultSet.getInt("contract_id");
                String service = resultSet.getString("attach_service_name");
                Temporary temporary = new Temporary(id,name,idContract,service);
                temporaryList.add(temporary);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return temporaryList;
    }

    @Override
    public List<Temporary> search(String searchName, String searchService) {
        List<Temporary> temporaryList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME_SERVICE);
            preparedStatement.setString(1, "%"+ searchName +"%");
            preparedStatement.setString(2, "%"+ searchService +"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");// columnLable : tên trường trong database// get theo kiểu dữ liệu của Java
                String name = resultSet.getString("customer_name");
                int idContract = resultSet.getInt("contract_id");
                String service = resultSet.getString("attach_service_name");
                Temporary temporary = new Temporary(id,name,idContract,service);
                temporaryList.add(temporary);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return temporaryList;
    }
}
