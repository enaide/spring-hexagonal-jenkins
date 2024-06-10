package com.ecfcode.hexagonal.infrastracture.entities.codejava.sale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class OrderDetailRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    void testListAll() {

    }

    @Test
    void testSaveNew() {
        Product product = new Product("Iphone 15", 1000);
        productRepository.save(product);

        Order order = new Order("Enaide Corrales", "In Progress");
        orderRepository.save(order);

        OrderDetailID  id = new OrderDetailID(order, product);
        OrderDetail orderDetail = new OrderDetail(2,1000);
        orderDetail.setId(id);
        orderDetail.setSubtotal(2000);
        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);

        assertThat(orderDetail1).isNotNull();
    }

}