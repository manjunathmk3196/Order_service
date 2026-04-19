package com.order.service.events;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class OrderCreatedEvent {

    private String eventId;

    private String eventType;

    private Instant timestamp;

    private OrderEventData data;
}
