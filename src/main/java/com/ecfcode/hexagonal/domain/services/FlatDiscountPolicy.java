package com.ecfcode.hexagonal.domain.services;

import com.ecfcode.hexagonal.domain.models.Order;
import com.ecfcode.hexagonal.domain.services.abstracts.DiscountPolicy;

public class FlatDiscountPolicy implements DiscountPolicy {
    @Override
    public double discount(Order order) {
        return 0.01;
    }
}
