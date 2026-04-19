package com.order.service.entity;

import com.order.service.OrderStatus;
import com.order.service.dto.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//@Document(collection = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    //@Id
    private String id;
    private Long customerId;
    private String orderDesc;
    private LocalDate orderDate;
    private Double totalPrice;
    private List<OrderItem> items;
    private LocalDateTime createdAt;
    private OrderStatus status;
}
