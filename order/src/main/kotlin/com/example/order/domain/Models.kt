package com.example.order.domain

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Order(
        val id: String = UUID.randomUUID().toString(),
        val status: OrderStatus = OrderStatus.PENDING,
        val at: LocalDateTime = LocalDateTime.now(),
        val value: BigDecimal = BigDecimal.ZERO
) {

    fun toOrderCreatedEvent() = OrderCreatedEvent(id, at, value)

    fun toOrderResponse() = OrderResponse(id, status, at, value)

}

data class OrderRequest(val value: BigDecimal = BigDecimal.ZERO) {

    fun toOrder() = Order(value = value)

}

data class OrderResponse(
        val id: String = UUID.randomUUID().toString(),
        val status: OrderStatus = OrderStatus.PENDING,
        val at: LocalDateTime = LocalDateTime.now(),
        val value: BigDecimal = BigDecimal.ZERO
)

data class OrderCreatedEvent(
        val id: String = UUID.randomUUID().toString(),
        val at: LocalDateTime = LocalDateTime.now(),
        val value: BigDecimal = BigDecimal.ZERO
)

enum class OrderStatus {

    PENDING,
    APPROVED,
    CANCELLED

}