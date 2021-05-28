package com.codegym.democ12.controller;

import com.codegym.democ12.entity.Product;
import com.codegym.democ12.entity.TypeProduct;
import com.codegym.democ12.service.ProductService;
import com.codegym.democ12.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TypeProductService typeProductService;

    @GetMapping("")
    public ModelAndView showList(@RequestParam(name = "nameProduct", required = false) String nameProduct,
                                 @RequestParam(name = "idTypeProduct", required = false) Long idTypeProduct,
                                 @RequestParam(name = "priceFrom", required = false) Double priceFrom,
                                 @RequestParam(name = "priceTo", required = false) Double priceTo) {
        System.out.println(idTypeProduct);
        ModelAndView modelAndView = new ModelAndView("list");
        List<TypeProduct> typeProductList = typeProductService.findAll();
        List<Product> productList = productService.findAll(nameProduct, idTypeProduct, priceFrom, priceTo,0);
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("typeProductList", typeProductList);
        if (!"".equals(nameProduct)) {
            modelAndView.addObject("nameProduct", nameProduct);
        }
        if (null != idTypeProduct) {
            modelAndView.addObject("idTypeProduct", idTypeProduct);
        }
        if (priceFrom != null){
            modelAndView.addObject("priceFrom", priceFrom);
        }
        if (priceTo != null){
            modelAndView.addObject("priceTo", priceTo);
        }
        return modelAndView;
    }
}
