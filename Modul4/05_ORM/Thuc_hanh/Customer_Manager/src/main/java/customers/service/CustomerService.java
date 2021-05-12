package customers.service;

import customers.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void  delete(int id);
    void update(Customer customer);
}
