package com.ecfcode.hexagonal.domain.services.abstracts;

import com.ecfcode.hexagonal.domain.models.OrderDO;

public interface DiscountPolicy {
    double discount(OrderDO order);
}
