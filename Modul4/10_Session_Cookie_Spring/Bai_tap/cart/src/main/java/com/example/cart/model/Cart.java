package com.example.cart.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Cart {
  private Map<Product, Integer> cart;
  public Cart() {
    cart = new HashMap<>();
  }
  public void addToCart(Product product){
    if(cart.containsKey(product)){
      cart.replace(product,cart.get(product),cart.get(product)+1);
    }else {
      cart.put(product,1);
    }
  }
  public void removeProduct(Product product){
    cart.remove(product);
  }
  public int getAmount(Product product){
    return cart.get(product);
  }

  public Map<Product, Integer> getCart() {
    return cart;
  }

  public void setCart(Map<Product, Integer> cart) {
    this.cart = cart;
  }

}
