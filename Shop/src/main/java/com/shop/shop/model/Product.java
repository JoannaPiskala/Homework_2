package com.shop.shop.model;


import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public class Product {

    @NonNull
    private Long productId;
    @NonNull
    private String productName;
    @NonNull
    private BigDecimal productPrice;

    public Product(long productId, String productName, BigDecimal productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;

    }

    public Product() {}

    public Long getId() {
        return productId;
    }

    public void setId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
