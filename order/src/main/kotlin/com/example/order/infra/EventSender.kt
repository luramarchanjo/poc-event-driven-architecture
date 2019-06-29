package com.example.order.infra

import com.example.order.domain.OrderCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class EventSender(val rabbitTemplate: RabbitTemplate) {

    val log = LoggerFactory.getLogger(this::class.java)

    fun publishOrderCreatedEvent(event: OrderCreatedEvent) {
        log.info("Publishing $event")
        rabbitTemplate.convertAndSend("order-created-queue", event)
    }

}