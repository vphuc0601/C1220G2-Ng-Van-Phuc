package com.example.case_study.repository;
import com.example.case_study.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
//    @Query("select s from Customer s where s.customer_name =:input ")
//    Page<Customer> findByName(@Param("input") String name, Pageable pageable);
@Query("SELECT p FROM Customer p WHERE CONCAT(p.customerName, p.customerAddress) LIKE %?1%")
public Page<Customer> search(String keyword, Pageable pageable);
}
