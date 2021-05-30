# Exchange

The project is a digital asset exchange.

## Tech stack

Using Spring Cloud Alibaba.

1. Nacos as Naming Service
2. Nacos as Config Service
3. OpenFeign as RPC
4. Seata as Distribute Transaction
5. RocketMQ as Message Queue
6. Spring Cloud Gateway as API Gateway
7. Sentinel as Rate Limit etc.
8. Spring & Spring Boot as Base Framework
9. MySQL as data store
10. Redis as Cache etc.
11. Hazelcast as In-Memory-Data-Grid
12. Kafka & Flink as Streaming process
13. Websocket as push / notification protocol


## Design

1. ex-order-srv -> port:19100
2. ex-account-srv -> port:19200
3. ex-matching-srv -> port:19300
4. ex-clearing-srv -> port:19400
5. ex-quotation-srv -> port:19500
6. ...
