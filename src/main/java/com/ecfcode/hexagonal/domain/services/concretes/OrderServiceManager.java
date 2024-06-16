package com.ecfcode.hexagonal.domain.services.concretes;

import com.ecfcode.hexagonal.domain.models.OrderDO;
import com.ecfcode.hexagonal.domain.models.OrderLineDO;
import com.ecfcode.hexagonal.domain.models.ProductDO;
import com.ecfcode.hexagonal.domain.exception.DomainException;
import com.ecfcode.hexagonal.domain.repository.OrderRepositoryDO;
import com.ecfcode.hexagonal.domain.services.abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceManager implements OrderService {

    private final OrderRepositoryDO orderRepository;

    public OrderServiceManager(final OrderRepositoryDO orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Long createOrder(List<OrderLineDO> orderLine) {
        OrderDO order = new OrderDO(orderLine);
        return orderRepository.save(order).getOrderId();
    }

    @Override
    public void addProduct(Long id, ProductDO product) {
        final OrderDO order = getOrder(id);
        order.addOrder(product,1);

        orderRepository.save(order);
    }

    @Override
    public void addOrderLine(Long id, OrderLineDO orderLine) {
        final OrderDO order = getOrder(id);
        order.addLineItem(orderLine);

        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(Long id, Long productId) {
        final OrderDO order = getOrder(id);
        order.removeLineItemByProductId(productId);

        orderRepository.save(order);
    }

    @Override
    public void deleteOrderLine(Long id, Long orderLine) {
        final OrderDO order = getOrder(id);
        order.removeLineItemByOrderLineId(orderLine);

        orderRepository.save(order);
    }

    @Override
    public void completeOrder(Long id) {
        final OrderDO order = getOrder(id);
        order.complete();

        orderRepository.save(order);
    }

    @Override
    public OrderDO fetchOrder(Long id) {
        return getOrder(id);
    }

    private OrderDO getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new DomainException("Order with given id doesn't exist"));
    }
}