package com.ecfcode.hexagonal.domain.services.concretes;

import com.ecfcode.hexagonal.domain.models.OrderDO;
import com.ecfcode.hexagonal.domain.services.abstracts.DiscountPolicy;

public class FlatDiscountPolicy implements DiscountPolicy {
    @Override
    public double discount(OrderDO order) {
        return 0.01;
    }
}
