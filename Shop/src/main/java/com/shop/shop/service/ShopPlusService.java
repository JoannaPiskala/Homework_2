package com.shop.shop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Profile("Plus")
@Service
public class ShopPlusService extends ShopService {

    @Value("${vat}")
    private double vat;

    public BigDecimal calcVat(BigDecimal price) {
        System.out.println("Vat: " + vat*100 + "%");
        BigDecimal vatValue = BigDecimal.valueOf(vat + 1);
        return price.multiply(vatValue);
    }
    public BigDecimal priceWithVat() {
        return calcVat(getBill());
    }

    @Override
    public void printBill() {
        BigDecimal billWithVat = priceWithVat().setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Bill with Vat: " + billWithVat);
    }

}
