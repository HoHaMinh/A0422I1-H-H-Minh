package customer_manager.repository;

import customer_manager.bean.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
// đây
@Transactional
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("select c from Customer c").getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        return entityManager.find(Customer.class,id);
    }


    /*
    * - Thêm @Transactional để thao tác CRUD với DB  -tutor- */
    @Override
    public Customer save(Customer customer) {
        if (customer.getId()==null) {
            entityManager.persist(customer);
        } else {
            entityManager.merge(customer);
        }
        return customer;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        entityManager.persist(customers);
        return customers;
    }

    @Override
    public boolean exists(Long id) {
        List<Customer> customerList = entityManager.createQuery("select c from Customer c where c.id = :id")
                .setParameter("id",id).getResultList();
        if (customerList!=null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return entityManager.createQuery("select c from Customer c").getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("select count (c.id) from Customer c group by c.id").getMaxResults();
    }

    @Override
    public void delete(Long id) {
        Customer customer = findOne(id);
        entityManager.remove(customer);
    }

    @Override
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        for (Customer C: customers
             ) {
            entityManager.remove(C);
        }
    }

    @Override
    public void deleteAll() {
        List<Customer> customerList = findAll();
        for (Customer C: customerList
             ) {
            entityManager.remove(C);
        }
    }
}
