package com.codegym.democ12.controller;

import com.codegym.democ12.entity.Product;
import com.codegym.democ12.entity.TypeProduct;
import com.codegym.democ12.service.ProductService;
import com.codegym.democ12.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TypeProductService typeProductService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> showList(@RequestParam(name = "nameProduct", required = false) String nameProduct,
                                                  @RequestParam(name = "idTypeProduct", required = false) Long idTypeProduct,
                                                  @RequestParam(name = "priceFrom", required = false) Double priceFrom,
                                                  @RequestParam(name = "priceTo", required = false) Double priceTo,
                                                  @RequestParam(name = "index", required = false) int index) {

        List<Product> productList = productService.findAll(nameProduct, idTypeProduct, priceFrom, priceTo, index);
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }
}
