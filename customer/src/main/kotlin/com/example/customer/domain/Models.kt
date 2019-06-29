package com.example.customer.domain

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class OrderCreatedEvent(
        val id: String = UUID.randomUUID().toString(),
        val value: BigDecimal = BigDecimal.ZERO
)

data class CreditReservedEvent(
        val id: String = UUID.randomUUID().toString(),
        val order: String = UUID.randomUUID().toString()
)

data class CreditLimitExceededEvent(
        val id: String = UUID.randomUUID().toString(),
        val order: String = UUID.randomUUID().toString()
)