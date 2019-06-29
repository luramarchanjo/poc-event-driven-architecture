package com.example.customer.infra

import com.example.customer.domain.CreditLimitExceededEvent
import com.example.customer.domain.CreditReservedEvent
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class EventSender(val rabbitTemplate: RabbitTemplate) {

    val log = LoggerFactory.getLogger(this::class.java)

    fun publishCreditReservedEvent(event: CreditReservedEvent) {
        log.info("Publishing $event")
        rabbitTemplate.convertAndSend("credit-reserved-queue", event)
    }

    fun publishCreditLimitExceededEvent(event: CreditLimitExceededEvent) {
        log.info("Publishing $event")
        rabbitTemplate.convertAndSend("credit-limit-exceeded-queue", event)
    }

}