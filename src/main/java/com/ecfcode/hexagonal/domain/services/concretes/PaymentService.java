package com.ecfcode.hexagonal.domain.services.concretes;

import com.ecfcode.hexagonal.domain.models.Currency;
import com.ecfcode.hexagonal.domain.models.OrderDO;
import com.ecfcode.hexagonal.domain.models.Payment;
import com.ecfcode.hexagonal.domain.services.PaymentCharger;
import com.ecfcode.hexagonal.domain.services.abstracts.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private static final List<Currency> ACCEPTED_CURRENCIES = List.of(Currency.USD, Currency.GBP);

    private final PaymentCharger paymentCharger;
    private final OrderService orderService;

    public PaymentService(PaymentCharger paymentCharger, OrderService orderService) {
        this.paymentCharger = paymentCharger;
        this.orderService = orderService;
    }

    public void chargeCard(Payment payment) {
        OrderDO order = payment.getOrderDO();
        System.out.println(order);
    }
}
