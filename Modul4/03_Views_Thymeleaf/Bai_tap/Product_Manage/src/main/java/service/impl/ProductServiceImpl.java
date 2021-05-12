package service.impl;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
private ProductRepository productRepository;

    @Override
    public List<Product> finAll() {
        return productRepository.finAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product finById(int id) {
        return productRepository.finById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

//    private static Map<Integer, Product> products;
//    static {
//        products =new HashMap<>();
//        products.put(1, new Product(1, "Iphone XMas", 2000, "New 100%"));
//        products.put(2, new Product(2, "Iphone 12", 3000, "New 100%"));
//        products.put(3, new Product(3, "Samsung Note 9", 2000, "Like New"));
//        products.put(4, new Product(4, "Oppo", 1000, "New 100%"));
//    }
//    @Override
//    public List<Product> finAll() {
//        return new ArrayList<>(products.values());
//    }
//
//    @Override
//    public void save(Product product) {
//        products.put(product.getId(), product);
//    }
//
//    @Override
//    public Product finById(int id) {
//        return products.get(id);
//    }
//
//    @Override
//    public void update(int id, Product product) {
//        products.put(id, product);
//    }
//
//    @Override
//    public void remove(int id) {
//        products.remove(id);
//    }
}
