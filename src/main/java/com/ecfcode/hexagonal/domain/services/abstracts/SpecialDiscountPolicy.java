package com.ecfcode.hexagonal.domain.services.abstracts;

import com.ecfcode.hexagonal.domain.models.SpecialOrder;

public interface SpecialDiscountPolicy extends DiscountPolicy {
    double discount(SpecialOrder order);
}
