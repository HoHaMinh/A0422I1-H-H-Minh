package Repository;

import Model.Customer;
import Model.Temporary;

import java.util.List;

public interface ITemporaryRepository {
    List<Temporary> showAll ();

    List<Temporary> search (String searchName, String searchService);
}
