package com.order.service.service;

import com.order.service.dto.OrderItem;

import java.util.List;

public interface PricingStrategy {
    double calculateTotal(List<OrderItem> items);
}
