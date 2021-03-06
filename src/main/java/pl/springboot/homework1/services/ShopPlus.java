package pl.springboot.homework1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.springboot.homework1.Product;
import pl.springboot.homework1.services.ProductService;


@Service
@Profile("PLUS")
public class ShopPlus {


    private ProductService productService;

    @Autowired
    public ShopPlus(ProductService productService) {
        this.productService = productService;
    }

    //@EventListener(ApplicationReadyEvent.class)
    //public void productsWithTax() {
    //    System.out.println("Ceny produktów: ");
    //    for (int i = 0; i < productService.showProduct().size(); i++) {
    //        System.out.println("Produkt: " + productService.showProduct().get(i).getProductName());
    //        double priceWithTax = productService.showProduct().get(i).getPrice() * (1 + productService.getTax());
    //        System.out.println("Cena z podatkiem VAT: " + Math.round(priceWithTax));
    //    }
//
    //}

    @EventListener(ApplicationReadyEvent.class)
    public void productWithTax2() {
        for (Product product : productService.showProduct()) {
            System.out.println(product.getProductName());
            double priceWithTax = product.getPrice() * (1 + productService.getTax());
            System.out.println("Cena z VAT: " + priceWithTax);

        }
    }

}
