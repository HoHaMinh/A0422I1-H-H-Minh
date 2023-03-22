package repository;

import model.RentHouse;

import java.util.List;
import java.util.Map;

public interface IRentHouseRepository {
    List<RentHouse> showAll ();
    boolean delete(int id);
    boolean add (RentHouse rentHouse);
    List<RentHouse> search (String searchId, String searchName, String searchPhone);
}
