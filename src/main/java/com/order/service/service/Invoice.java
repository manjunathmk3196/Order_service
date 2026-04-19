package com.order.service.service;

import com.order.service.entity.Order;

public interface Invoice {
    String generateInvoice(Order order);
}
