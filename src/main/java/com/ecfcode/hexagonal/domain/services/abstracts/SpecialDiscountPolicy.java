package com.ecfcode.hexagonal.domain.services.abstracts;

import com.ecfcode.hexagonal.domain.models.SpecialOrderDO;

public interface SpecialDiscountPolicy extends DiscountPolicy {
    double discount(SpecialOrderDO order);
}
