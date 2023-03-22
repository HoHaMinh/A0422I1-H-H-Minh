package repository;

import model.RentHouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentHouseRepository implements IRentHouseRepository{

    private final String DELETE = "delete from rent_house where rent_house_id =?;";
    private final String ADD_CUSTOMER = "INSERT INTO rent_house" + "  (rent_name, phone, start_date, payment_id, note) VALUES " +
            " (?, ?, ?, ?, ?);";

    private final String SEARCH_ID_NAME_PHONE ="select * from temp where house_id like ? and rent_name like ? and phone like ?;";
    private final String SELECT_ALL = "SELECT * FROM temp;";
    @Override
    public List<RentHouse> showAll() {
        List<RentHouse> rentHouseList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("house_id");
                String name = resultSet.getString("rent_name");
                String phone = resultSet.getString("phone");
                String startDate = resultSet.getString("start_date");
                String paymentType = resultSet.getString("payment_type");
                String note = resultSet.getString("note");
                RentHouse rentHouse = new RentHouse(id, name, phone, startDate, paymentType,note);
                rentHouseList.add(rentHouse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentHouseList;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(RentHouse rentHouse) {
        int paymentType=0;

        switch (rentHouse.getPayment_type()) {
            case "1":
                paymentType=1;
                break;
            case "2":
                paymentType=2;
                break;
            case "3":
                paymentType=3;
        }
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER)) {
            preparedStatement.setString(1, rentHouse.getRent_name());
            preparedStatement.setString(2, rentHouse.getPhone());
            preparedStatement.setDate(3, Date.valueOf(rentHouse.getStart_date()));
            preparedStatement.setInt(4, paymentType);
            preparedStatement.setString(5, rentHouse.getNote());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<RentHouse> search(String searchId, String searchName, String searchPhone) {
        List<RentHouse> rentHouseList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ID_NAME_PHONE);
            preparedStatement.setString(1, "%"+ searchId +"%");
            preparedStatement.setString(2, "%"+ searchName +"%");
            preparedStatement.setString(3, "%"+ searchPhone +"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("house_id");
                String name = resultSet.getString("rent_name");
                String phone = resultSet.getString("phone");
                String startDate = resultSet.getString("start_date");
                String paymentType = resultSet.getString("payment_type");
                String note = resultSet.getString("note");
                RentHouse rentHouse = new RentHouse(id, name, phone, startDate, paymentType,note);
                rentHouseList.add(rentHouse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentHouseList;
    }
}
