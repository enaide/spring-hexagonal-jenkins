package com.ecfcode.hexagonal.domain.services.abstracts;

import com.ecfcode.hexagonal.domain.models.Order;

public interface DiscountPolicy {
    double discount(Order order);
}
