package pl.springboot.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
@Profile("PLUS")
public class ShopPlus {


    private ProductService productService;

    @Autowired
    public ShopPlus(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void productsWithTax() {
        System.out.println("Ceny produktów: ");
        for (int i = 0; i < productService.showProduct().size(); i++) {
            System.out.println("Produkt: " + productService.showProduct().get(i).getProductName());
            double priceWithTax = productService.showProduct().get(i).getPrice() * (1 + productService.getTax());
            System.out.println("Cena z podatkiem VAT: " + Math.round(priceWithTax));
        }

    }
}
