package com.ecfcode.hexagonal.domain.services.abstracts;

import com.ecfcode.hexagonal.domain.entities.OrderLine;
import com.ecfcode.hexagonal.domain.entities.Product;

import java.util.List;

public interface OrderService {
    Long createOrder(List<OrderLine> orderLine);

    void addProduct(Long id, Product product);

    void deleteProduct(Long id, Long productId);

    void addOrderLine(Long id, OrderLine orderLine);

    void deleteOrderLine(Long id, Long orderLine);

    void completeOrder(Long id);
}
