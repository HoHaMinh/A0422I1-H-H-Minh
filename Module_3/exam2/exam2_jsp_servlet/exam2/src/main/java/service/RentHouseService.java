package service;

import model.RentHouse;
import repository.IRentHouseRepository;
import repository.RentHouseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentHouseService implements IRentHouseService{
    private IRentHouseRepository rentHouseRepository = new RentHouseRepository();
    @Override
    public List<RentHouse> showAll() {
        return rentHouseRepository.showAll();
    }

    @Override
    public boolean delete(int id) {
        rentHouseRepository.delete(id);
        return true;
    }

    @Override
    public boolean add(RentHouse rentHouse) {
            rentHouseRepository.add(rentHouse);
        return true;
    }

    @Override
    public List<RentHouse> search(String searchId, String searchName, String searchPhone) {
        return rentHouseRepository.search(searchId,searchName,searchPhone);
    }
}
