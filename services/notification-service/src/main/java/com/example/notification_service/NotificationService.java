package com.example.notification_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotificationService {
    
    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @KafkaListener(topics = "order-placed")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent){
        log.info("Received Notification for Order - {}", orderPlacedEvent);
    }
}
