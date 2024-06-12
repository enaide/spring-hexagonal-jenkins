package com.ecfcode.hexagonal.domain.services;

import com.ecfcode.hexagonal.domain.models.Order;
import com.ecfcode.hexagonal.domain.services.abstracts.DiscountPolicy;

import java.math.BigDecimal;

public class AmountBasedDiscountPolicy implements DiscountPolicy {
    @Override
    public double discount(Order order) {
        if (order.totalCost().compareTo(BigDecimal.valueOf(500.00)) > 0) {
            return 0.10;
        } else
            return 0;
    }
}
