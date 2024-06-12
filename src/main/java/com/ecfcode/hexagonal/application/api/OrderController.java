package com.ecfcode.hexagonal.application.api;

import com.ecfcode.hexagonal.domain.requests.demo.AddProductRequest;
import com.ecfcode.hexagonal.domain.requests.demo.CreateOrderRequest;
import com.ecfcode.hexagonal.domain.responses.CreateOrderResponse;
import com.ecfcode.hexagonal.domain.services.abstracts.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateOrderResponse createOrder(@RequestBody final CreateOrderRequest createOrderRequest) {
        final Long id = orderService.createOrder(List.of(createOrderRequest.orderLine()));

        return new CreateOrderResponse(id);
    }

    @PostMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addProduct(@PathVariable final Long id, @RequestBody final AddProductRequest addProductRequest) {
        orderService.addProduct(id, addProductRequest.product());
    }

    @DeleteMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteProduct(@PathVariable final Long id, @RequestParam final Long productId) {
        orderService.deleteProduct(id, productId);
    }

    @PostMapping("/{id}/complete")
    void completeOrder(@PathVariable final Long id) {
        orderService.completeOrder(id);
    }
}
