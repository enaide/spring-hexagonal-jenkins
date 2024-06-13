package com.ecfcode.hexagonal.domain.services.abstracts;

import com.ecfcode.hexagonal.domain.models.OrderLineDO;
import com.ecfcode.hexagonal.domain.models.ProductDO;

import java.util.List;

public interface OrderService {
    Long createOrder(List<OrderLineDO> orderLine);

    void addProduct(Long id, ProductDO product);

    void deleteProduct(Long id, Long productId);

    void addOrderLine(Long id, OrderLineDO orderLine);

    void deleteOrderLine(Long id, Long orderLine);

    void completeOrder(Long id);
}
