package com.order.service.service.impl;

import com.order.service.entity.Order;
import com.order.service.service.Invoice;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements Invoice {

    @Override
    public String generateInvoice(Order order) {
        return "Invoice-PDF-" + order.getId();
    }
}
