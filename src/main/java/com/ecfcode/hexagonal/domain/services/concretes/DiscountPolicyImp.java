package com.ecfcode.hexagonal.domain.services.concretes;

import com.ecfcode.hexagonal.domain.models.OrderDO;
import com.ecfcode.hexagonal.domain.models.SpecialOrderDO;
import com.ecfcode.hexagonal.domain.services.abstracts.SpecialDiscountPolicy;

public class DiscountPolicyImp implements SpecialDiscountPolicy {
    @Override
    public double discount(OrderDO order) {
        return 0;
    }

    @Override
    public double discount(SpecialOrderDO order) {
        if (order.isEligibleForExtraDiscount())
            return 0.20;
        return 0.10;
    }
}
