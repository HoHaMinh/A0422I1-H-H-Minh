package Service;

import Model.Service;

import java.util.List;

public interface IServiceService {
    List<Service> showAll ();
    List<Service> findByName (String name);
    boolean add (Service service);
    boolean edit (Service service);
    boolean delete (int id);
}
