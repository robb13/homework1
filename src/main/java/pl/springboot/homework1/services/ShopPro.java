package pl.springboot.homework1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.springboot.homework1.Product;
import pl.springboot.homework1.services.ProductService;


@Service
@Profile("PRO")
public class ShopPro {

    private ProductService productService;

    @Autowired
    public ShopPro(ProductService productService) {
        this.productService = productService;
    }

    //@EventListener(ApplicationReadyEvent.class)
    //public void productsWithTaxAndDiscount() {
//
    //    for (int i = 0; i < productService.showProduct().size(); i++) {
    //        double productPriceNormal = productService.showProduct().get(i).getPrice() * (1 + productService.getTax());
    //        double productPriceDiscount = productPriceNormal - (productPriceNormal * productService.getDiscount());
    //        System.out.println(productService.showProduct().get(i).getProductName() + " cena z VAT: " + Math.round(productPriceNormal));
    //        System.out.println("Cena po rabacie z podatkiem VAT: " + Math.round(productPriceDiscount));
    //    }
//
//
    //}

    @EventListener(ApplicationReadyEvent.class)
    public void productsWithTaxAndDiscount2() {
        for (Product product : productService.showProduct()) {
            double productPriceNormal = product.getPrice() * (1 + productService.getTax());
            double productPriceDiscount = productPriceNormal - (productPriceNormal * (productService.getDiscount()));
            System.out.println(product.getProductName() + " Cena z VAT po rabacie: " + Math.round(productPriceDiscount) + " zł.");
        }
    }


}
