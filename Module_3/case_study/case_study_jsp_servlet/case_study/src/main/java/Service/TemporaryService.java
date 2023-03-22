package Service;

import Model.Customer;
import Model.Temporary;
import Repository.ITemporaryRepository;
import Repository.TemporaryRepository;

import java.util.List;

public class TemporaryService implements ITemporaryService{
    private ITemporaryRepository temporaryRepository = new TemporaryRepository();
    @Override
    public List<Temporary> showAll() {
        return temporaryRepository.showAll();
    }

    @Override
    public List<Temporary> search(String searchName, String searchService) {
        return temporaryRepository.search(searchName,searchService);
    }
}
