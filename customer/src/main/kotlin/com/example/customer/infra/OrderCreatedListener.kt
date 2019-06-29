package com.example.customer.infra

import com.example.customer.domain.CreditLimitExceededEvent
import com.example.customer.domain.CreditReservedEvent
import com.example.customer.domain.OrderCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderCreatedListener(val eventSender: EventSender) {

    val log = LoggerFactory.getLogger(this::class.java)

    @RabbitListener(queues = ["order-created-queue"])
    fun listener(event: OrderCreatedEvent) {
        log.info("Consuming $event")
        // Do some business logic
        // ...

        // Emit event CreditReserved or CreditLimitExceeded
        if (Random().nextBoolean()) {
            eventSender.publishCreditReservedEvent(CreditReservedEvent(order = event.id))
        } else {
            eventSender.publishCreditLimitExceededEvent(CreditLimitExceededEvent(order = event.id))
        }

        log.info("Consumed $event")
    }

}