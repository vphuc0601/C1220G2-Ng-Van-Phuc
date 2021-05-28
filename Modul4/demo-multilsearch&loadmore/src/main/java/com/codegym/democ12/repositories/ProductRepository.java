package com.codegym.democ12.repositories;

import com.codegym.democ12.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM Product product where (?1 IS NULL   OR name_product LIKE %?1%)\n" +
            "  AND (?2 IS NULL    OR id_type_product = ?2)\n" +
            "  AND ( ?3 IS NULL  OR price >= ?3  )\n" +
            "  AND ( ?4 IS NULL  OR price <= ?4 ) \n " +
            " LIMIT ?5 , 3;", nativeQuery = true)
     List<Product> searchAdvance(String name_product, Long id_type_product, Double priceFrom, Double priceTo, int index);
}
