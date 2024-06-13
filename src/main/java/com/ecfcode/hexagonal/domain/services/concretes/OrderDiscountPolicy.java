package com.ecfcode.hexagonal.domain.services.concretes;

import com.ecfcode.hexagonal.domain.models.OrderDO;
import com.ecfcode.hexagonal.domain.models.OrderLineDO;
import com.ecfcode.hexagonal.domain.services.abstracts.SpecialDiscountPolicy;

import java.math.BigDecimal;
import java.util.List;

public class OrderDiscountPolicy extends OrderDO {
    public OrderDiscountPolicy(List<OrderLineDO> orderLines) {
        super(orderLines);
    }

    public BigDecimal totalCost(SpecialDiscountPolicy discountPolicy) {
        return totalCost().multiply(BigDecimal.valueOf(1 - applyDiscountPolicy(discountPolicy)));
    }

    @Override
    protected double applyDiscountPolicy(SpecialDiscountPolicy discountPolicy) {
        return discountPolicy.discount(this);
    }
}
