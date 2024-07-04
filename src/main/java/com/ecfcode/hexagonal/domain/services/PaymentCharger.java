package com.ecfcode.hexagonal.domain.services;

import com.ecfcode.hexagonal.domain.models.CardPaymentCharge;
import com.ecfcode.hexagonal.domain.models.Currency;

import java.math.BigDecimal;

public interface PaymentCharger {

    CardPaymentCharge chargeCard(
            String cardSource,
            BigDecimal amount,
            Currency currency,
            String description
    );
}
