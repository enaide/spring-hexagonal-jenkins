package com.ecfcode.hexagonal.domain.models;

import com.ecfcode.hexagonal.domain.services.abstracts.SpecialDiscountPolicy;

import java.util.List;

public class SpecialOrder extends Order {

    private final boolean eligibleForExtraDiscount;

    public SpecialOrder(List<OrderLine> orderLines) {
        super(orderLines);
        this.eligibleForExtraDiscount = false;
    }

    public SpecialOrder(List<OrderLine> orderLines, boolean eligibleForSpecialDiscount) {
        super(orderLines);
        this.eligibleForExtraDiscount = eligibleForSpecialDiscount;
    }

    public boolean isEligibleForExtraDiscount() {
        return eligibleForExtraDiscount;
    }

    @Override
    protected double applyDiscountPolicy(SpecialDiscountPolicy discountPolicy) {
        return discountPolicy.discount(this);
    }
}
