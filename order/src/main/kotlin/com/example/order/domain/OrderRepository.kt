package com.example.order.domain

import com.example.order.infra.EventSender
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class OrderRepository(val eventSender: EventSender) {

    val log = LoggerFactory.getLogger(this::class.java)

    // Memory database
    val orders = mutableMapOf<String, Order>()

    fun save(order: Order = Order()): Order? {
        log.info("Saving $order")
        orders.putIfAbsent(order.id, order)
        eventSender.publishOrderCreatedEvent(order.toOrderCreatedEvent())

        return order
    }

    fun findAll(): Collection<Order> {
        log.info("Finding all orders")
        return orders.values
    }

    fun deleteAll() {
        log.info("Deleting all orders")
        return orders.clear()
    }

    fun updateStatus(orderId: String, status: OrderStatus) {
        log.info("Updating status=[$status] order=[$orderId]")
        val order = orders.get(orderId)
        if (order != null) {
            order.status = status
            orders.put(orderId, order)
        } else {
            log.warn("Order=[$orderId] not found")
        }
    }

}