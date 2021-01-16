package com.shop.shop.service;

import com.shop.shop.model.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Profile("Start")
@Service
public class ShopService {

    private List<Product> products;

    @EventListener(ApplicationReadyEvent.class)
    public void shopStart() {
        products = initialProducts();
        products.forEach(System.out::println);
        printBill();
    }

    private List<Product> initialProducts() {
        List<Product> initialProducts = new ArrayList<>();
        initialProducts.add(new Product(1,"Product1", prepareRandomPrice()));
        initialProducts.add(new Product(2,"Product1", prepareRandomPrice()));
        initialProducts.add(new Product(3,"Product1", prepareRandomPrice()));
        initialProducts.add(new Product(4,"Product1", prepareRandomPrice()));
        initialProducts.add(new Product(5,"Product1", prepareRandomPrice()));
        return initialProducts;
    }

        public BigDecimal prepareRandomPrice() {
        Random rr = new Random();
        double min = 50.00;
        double max = 300.00;
        return BigDecimal.valueOf(Math.round((min+(rr.nextDouble()*(max-min)))* 100.00)/100.00);
        }

        public BigDecimal getBill() {
        return products.stream().map(Product::getProductPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        }

        public void printBill() {
            System.out.println("Bill: " + getBill());
        }

    /*
    possibly for future use
            public Product addProduct(Product product) {
            products.add(product);
            return product;
            }

     */

}

