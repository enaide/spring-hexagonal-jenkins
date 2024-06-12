package com.ecfcode.hexagonal.order;

import com.ecfcode.hexagonal.domain.models.OrderLine;
import com.ecfcode.hexagonal.domain.models.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class OrderFixtureUtils {
    public static List<OrderLine> anyOrderLines() {
        return Arrays.asList(new OrderLine(new Product(1L,BigDecimal.valueOf(100)), 1));
    }

    public static List<OrderLine> orderLineItemsWorthNDollars(int totalCost) {
        return Arrays.asList(new OrderLine(new Product(1L,BigDecimal.valueOf(totalCost)), 1));
    }

}
