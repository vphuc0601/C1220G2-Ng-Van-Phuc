package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> finAll();

    void save(Product product);

    Product finById(int id);

    void update(Product product);

    void remove(int id);
}
