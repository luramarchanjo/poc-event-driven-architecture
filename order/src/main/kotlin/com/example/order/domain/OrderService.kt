package com.example.order.domain

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class OrderService(val repository: OrderRepository) {

    val log = LoggerFactory.getLogger(this::class.java)

    fun create(order: Order): Order? {
        log.info("Creating $order")
        return repository.save(order)
    }

    fun orders(): Collection<Order> {
        log.info("Getting all orders")
        return repository.findAll()
    }

    fun deleteOrders() {
        log.info("Deleting all orders")
        repository.deleteAll()
    }

    fun updateStatus(order: String, status: OrderStatus) {
        log.info("Updating status=[$status] order=[$order]")
        repository.updateStatus(order, status)
    }

}