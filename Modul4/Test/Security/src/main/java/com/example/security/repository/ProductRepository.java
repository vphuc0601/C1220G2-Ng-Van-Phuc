package com.example.security.repository;

//import com.example.product_manager.entity.Product;
import com.example.security.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE CONCAT(p.name, p.price) LIKE %?1%")
    public Page<Product> searchProduct(String keyword, Pageable pageable);
    Product findProductByName(String name);
}
