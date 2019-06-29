package com.example.order.infra

import com.example.order.domain.CreditLimitExceededEvent
import com.example.order.domain.CreditReservedEvent
import com.example.order.domain.OrderService
import com.example.order.domain.OrderStatus
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class CreditLimitExceededListener(val orderService: OrderService) {

    val log = LoggerFactory.getLogger(this::class.java)

    @RabbitListener(queues = ["credit-limit-exceeded-queue"])
    fun listener(event: CreditLimitExceededEvent) {
        log.info("Consuming $event")
        orderService.updateStatus(event.order, OrderStatus.CANCELLED)
        log.info("Consumed $event")
    }

}