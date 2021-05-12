package repository.impl;

import model.Product;
import org.springframework.stereotype.Repository;
import repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@PersistenceContext
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager entityManager;
    @Override
    public List<Product> finAll() {
        TypedQuery<Product> typedQuery =
                entityManager.createQuery("select s from product s", Product.class);

        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product finById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(int id) {
        entityManager.remove(finById(id));
    }
}
