package com.shop.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShopStart {

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        System.out.println("Shop " + activeProfile);
    }
}
