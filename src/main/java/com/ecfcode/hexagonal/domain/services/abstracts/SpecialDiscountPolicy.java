package com.ecfcode.hexagonal.domain.services.abstracts;

import com.ecfcode.hexagonal.domain.entities.SpecialOrder;

public interface SpecialDiscountPolicy extends DiscountPolicy {
    double discount(SpecialOrder order);
}
