package com.order.service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class CreateOrder {

    @NotNull
    private Long customerId;
    private String orderDesc;
    private LocalDate orderDate;
    @NotEmpty
    private List<OrderItem> items;
}
