package com.shop.shop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Profile("Pro")
@Service
public class ShopProService extends ShopPlusService {

    @Value("${discount}")
    private double discount;


    public BigDecimal calcDiscount(BigDecimal price) {
        System.out.println("Discount: " + discount*100 + "%");
        BigDecimal discountValue = BigDecimal.valueOf(1 - discount);
        return price.multiply(discountValue);
    }

    @Override
    public void printBill() {
        BigDecimal billWithVandD = calcDiscount(priceWithVat()).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Bill with Vat including discount: " + billWithVandD);
    }

}
