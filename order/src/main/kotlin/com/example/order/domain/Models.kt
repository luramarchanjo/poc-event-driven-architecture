package com.example.order.domain

import java.math.BigDecimal
import java.util.*

data class Order(
        val id: String = UUID.randomUUID().toString(),
        var status: OrderStatus = OrderStatus.PENDING,
        val value: BigDecimal = BigDecimal.ZERO
) {

    fun toOrderCreatedEvent() = OrderCreatedEvent(id, value)

    fun toOrderResponse() = OrderResponse(id, status, value)

}

data class OrderRequest(val value: BigDecimal = BigDecimal.ZERO) {

    fun toOrder() = Order(value = value)

}

data class OrderResponse(
        val id: String = UUID.randomUUID().toString(),
        val status: OrderStatus = OrderStatus.PENDING,
        val value: BigDecimal = BigDecimal.ZERO
)

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

enum class OrderStatus {

    PENDING,
    APPROVED,
    CANCELLED

}