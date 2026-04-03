# Day 12 - Async Processing

## Problem

Processing heavy operations inside API requests creates:

* blocking requests
* slow responses
* timeouts
* low scalability
* tight coupling

## Bad Practice

Client → API → Services

The API waits for all services to finish.

## Good Practice

Client → API → Queue → Worker → Services

The API responds immediately.

## HTTP Status

202 Accepted

The request was received and will be processed asynchronously.

## Benefits

* non-blocking API
* faster response
* scalable architecture
* background processing
* decoupled services

## Technologies

* Kafka
* RabbitMQ
* AWS SQS
* Spring Async
* Workers
* Event Driven Architecture

## Key Idea

APIs should respond fast.

Heavy work should run in background.
