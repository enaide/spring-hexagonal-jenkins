package com.ecfcode.hexagonal.domain.services;

import com.ecfcode.hexagonal.domain.models.Order;
import com.ecfcode.hexagonal.domain.models.OrderLine;
import com.ecfcode.hexagonal.domain.models.Product;
import com.ecfcode.hexagonal.domain.exception.DomainException;
import com.ecfcode.hexagonal.domain.repository.OrderRepository;
import com.ecfcode.hexagonal.domain.services.abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImp(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Long createOrder(List<OrderLine> orderLine) {
        Order order = new Order(orderLine);

        return orderRepository.save(order).getOrderId();
    }

    @Override
    public void addProduct(Long id, Product product) {
        final Order order = getOrder(id);
        order.addOrder(product,1);

        orderRepository.save(order);
    }

    @Override
    public void addOrderLine(Long id, OrderLine orderLine) {
        final Order order = getOrder(id);
        order.addLineItem(orderLine);

        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(Long id, Long productId) {
        final Order order = getOrder(id);
        order.removeLineItemByProductId(productId);

        orderRepository.save(order);
    }

    @Override
    public void deleteOrderLine(Long id, Long orderLine) {
        final Order order = getOrder(id);
        order.removeLineItemByOrderLineId(orderLine);

        orderRepository.save(order);
    }

    @Override
    public void completeOrder(Long id) {
        final Order order = getOrder(id);
        order.complete();

        orderRepository.save(order);
    }

    private Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new DomainException("Order with given id doesn't exist"));
    }
}