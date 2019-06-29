# Overview

This is a simple poc using [Event-driven Architecture(EDA)]

# Setup

## RabbitMQ

1. Execute the command `docker run -d --rm --name=rabbitmq --net=host rabbitmq:latest`

## Customer

1. Execute the command `mvn clean spring-boot:run`

## Order

1. Execute the command `mvn clean spring-boot:run`

# Test

Create Order

---
curl -X POST \
  http://localhost:8080/orders \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 8236e942-76a4-4482-99c6-472759852058' \
  -H 'cache-control: no-cache' \
  -d '{
	"value" : 55.22
}'
---

Get Order

---
curl -X GET \
  http://localhost:8080/orders \
  -H 'Postman-Token: 3a4828f9-5e42-4470-90b8-135bcd574164' \
  -H 'cache-control: no-cache'
---

# Cleanup

1. Execute the command `docker stop rabbitmq && docker image rm rabbitmq:latest`


[Event-driven Architecture(EDA)]: https://microservices.io/patterns/data/event-driven-architecture.html