package pl.springboot.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
@Profile("PRO")
public class ShopPro {

    private ProductService productService;

    @Autowired
    public ShopPro(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void productsWithTaxAndDiscount() {

        for (int i = 0; i < productService.showProduct().size(); i++) {
            double productPriceNormal = productService.showProduct().get(i).getPrice() * (1 + productService.getTax());
            double productPriceDiscount = productPriceNormal - (productPriceNormal * productService.getDiscount());
            System.out.println(productService.showProduct().get(i).getProductName() + " cena z VAT: " + Math.round(productPriceNormal));
            System.out.println("Cena po rabacie z podatkiem VAT: " + Math.round(productPriceDiscount));
        }


    }


}
