package com.order.service.service.impl;

import com.order.service.OrderStatus;
import com.order.service.dto.CreateOrder;
import com.order.service.dto.OrderItem;
import com.order.service.dto.OrderResponse;
import com.order.service.entity.Order;
import com.order.service.events.publisher.EventPublisher;
import com.order.service.service.PricingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManagementService {

    //private final OrderRepository orderRepository;
    private final PricingStrategy pricingStrategy;
    private final InvoiceService invoiceService;
    private final EventPublisher eventPublisher;

    public OrderResponse createOrder(CreateOrder request) {

        List<OrderItem> orderItems = request.getItems().stream()
                .map(item -> OrderItem.builder()
                        .productId(item.getProductId())
                        .quantity(item.getQuantity())
                        .price(fetchPrice(item.getProductId()))
                        .build())
                .toList();

        double total = pricingStrategy.calculateTotal(orderItems);

        Order order = Order.builder()
                .customerId(request.getCustomerId())
                .items(orderItems)
                .totalPrice(total)
                .status(OrderStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .build();

        //order = orderRepository.save(order); //todo- align mongo connections

        // Generate Invoice
        String invoiceId = invoiceService.generateInvoice(order);

        // Publish Event
        eventPublisher.publishOrderCreated(order);

        return OrderResponse.builder()
                .orderId(order.getId())
                .totalPrice(total)
                .status(order.getStatus().name())
                .build();
    }

    private double fetchPrice(String productId) {
        // make http call and get data
        // ask item folks to impl caching
        return 1.0;
    }
}
