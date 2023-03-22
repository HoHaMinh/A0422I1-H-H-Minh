package Service;

import Model.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> showAll ();
    List<Contract> findById (int id);
    boolean add (Contract contract);
    boolean edit (Contract contract);
    boolean delete (int id);
}
