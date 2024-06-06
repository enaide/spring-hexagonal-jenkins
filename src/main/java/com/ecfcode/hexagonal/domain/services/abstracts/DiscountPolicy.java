package com.ecfcode.hexagonal.domain.services.abstracts;

import com.ecfcode.hexagonal.domain.entities.Order;

public interface DiscountPolicy {
    double discount(Order order);
}
