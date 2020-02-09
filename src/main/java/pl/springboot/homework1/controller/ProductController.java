package pl.springboot.homework1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.springboot.homework1.Product;
import pl.springboot.homework1.services.ProductService;

import java.util.List;

@RestController
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getInfo() {
        return productService.showProduct();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showProducts() {
        System.out.println(getInfo());

    }

    @EventListener(ApplicationReadyEvent.class)
    public void totalPrice() {
        System.out.println("Suma wszystkich produktów: " + productService.getTotal());
    }

}





