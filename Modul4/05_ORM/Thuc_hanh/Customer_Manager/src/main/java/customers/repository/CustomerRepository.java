package customers.repository;

import customers.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void  delete(int id);
    void update(Customer customer);
}
