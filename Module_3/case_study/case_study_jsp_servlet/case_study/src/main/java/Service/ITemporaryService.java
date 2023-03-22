package Service;

import Model.Customer;
import Model.Temporary;

import java.util.List;

public interface ITemporaryService {
    List<Temporary> showAll ();

    List<Temporary> search (String searchName, String searchService);
}
