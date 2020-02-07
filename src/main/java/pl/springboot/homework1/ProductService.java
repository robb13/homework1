package pl.springboot.homework1;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

   // public static final double TAX = 1.23;
   // public static final double DISCOUNT = 0.4;
    private List<Product> products;
    private double total;


    @Value("${page.info.tax}")
    private double tax;

    @Value("${page.info.discount}")
    private double discount;

    public double getTax() {
        return tax;
    }

    public double getDiscount() {
        return discount;
    }

    public ProductService() {

        Product product1 = new Product("Amiga", randGen());
        Product product2 = new Product("Commodore", randGen());
        Product product3 = new Product("Atari", randGen());
        Product product4 = new Product("ZX", randGen());
        Product product5 = new Product("Nintendo", randGen());

        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

    }

    public List<Product> showProduct() {
        return products;

    }

    public double randGen() {
        double minValue = 50.00;
        double maxValue = 300.00;
        Random random = new Random();
        return Math.round(minValue + (maxValue - minValue) * random.nextDouble());
    }

    public double getTotal() {

        for (Product product : products) {
            total += product.getPrice();
        }
        return total;

    }
}


