package com.order.service.events.publisher;

import com.order.service.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventPublisher {

    public void publishOrderCreated(Order order) {
        log.info("Publishing Order Created Event: " + order.getId());

        //todo- impl publisher -> use Docker Compose and spring-kafka dependency
        // KafkaTemplate.send()
    }
}
