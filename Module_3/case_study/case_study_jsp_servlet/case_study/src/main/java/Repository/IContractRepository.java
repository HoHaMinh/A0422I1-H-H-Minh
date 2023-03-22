package Repository;

import Model.Contract;

import java.util.List;

public interface IContractRepository {
    List<Contract> showAll ();
    List<Contract> findById (int id);
    boolean add (Contract contract);
    boolean edit (Contract contract);
    boolean delete (int id);
}
