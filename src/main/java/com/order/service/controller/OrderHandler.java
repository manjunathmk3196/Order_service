package com.order.service.controller;

import com.order.service.dto.CreateOrder;
import com.order.service.dto.OrderResponse;
import com.order.service.service.impl.OrderManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderHandler {

    private final OrderManagementService orderManagementService;

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody @Valid CreateOrder request) {
        log.info("creating {}, order for: {}",request.getOrderDesc(),request.getCustomerId());
        return ResponseEntity.ok(orderManagementService.createOrder(request));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable String orderId) {
        // future implementation
        return ResponseEntity.ok(null);
    }
}
