package com.example.security.repository;


import com.example.security.entity.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
    @Query("SELECT p FROM ProductOrder p WHERE CONCAT(p.dayOrder,p.quantity) LIKE %?1%")
    public Page<ProductOrder> searchProductOrder(String keyword, Pageable pageable);
    @Query("SELECT c FROM ProductOrder c WHERE " +
            "c.quantity LIKE %?1% OR " +
            "c.dayOrder LIKE %?1%")
    Page<ProductOrder> findAllByKey(String keyword, Pageable pageable);
    @Query("SELECT c FROM ProductOrder c WHERE " +
            "c.quantity LIKE %?1% AND " +
            "c.dayOrder LIKE %?2%")
    Page<ProductOrder> findAllByKeyword(String keyword1, String keyword2, Pageable pageable);

    @Query(value = " select * from product p  join bill b on p.id = b.product_id join productorder pd on b.product_order_id=pd.id where p.product_name like %?1% and pd.day_order = ?2 "
            , nativeQuery = true)
    Page<ProductOrder> findByAll(String keyword1, String keyword2, Pageable pageable);
}
