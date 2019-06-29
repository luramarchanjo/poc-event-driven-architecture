package com.example.order.domain

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController(val service: OrderService) {

    @PostMapping
    fun post(@RequestBody body: OrderRequest) = service.create(body.toOrder())?.toOrderResponse()

    @GetMapping
    fun getAll() = service.orders()

    @DeleteMapping
    fun deleteAll() = service.deleteOrders()

}