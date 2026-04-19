package com.order.service.events;

import com.order.service.dto.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderEventData {

    private String orderId;

    private Long customerId;

    private LocalDate orderDate;

    private Double totalPrice;

    private List<OrderItem> items;
}
