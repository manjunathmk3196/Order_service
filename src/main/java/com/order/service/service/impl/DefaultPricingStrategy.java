package com.order.service.service.impl;

import com.order.service.dto.OrderItem;
import com.order.service.service.PricingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public double calculateTotal(List<OrderItem> items) {
        return items.stream()
                .mapToDouble(i -> getItemPrice(i.getItemName()) * i.getQuantity())
                .sum();
    }

    private double getItemPrice(String itemName) {
        // make http call to item service and get the value (get details from team)
        // ask items repo folks to impl caching at their end
        return 1;
    }
}
