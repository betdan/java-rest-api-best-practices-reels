Day 01 - Clean REST Controller

Goal

Explain why REST controllers must be thin and focused only on HTTP interaction.

Key Concept

Controllers are part of the presentation layer.

They should not contain business logic.

Responsibilities

Receive HTTP requests
Validate input
Call service layer
Return HTTP response

Responsibilities that should NOT exist

Business logic
Database access
Complex decision making
Data transformations
External service calls

Correct Flow

Client
Controller
Service
Repository
Database

Why this matters

Improves maintainability
Reduces coupling
Simplifies testing
Improves scalability
Supports clean architecture

Anti Pattern

Controller calling repository directly

Controller doing calculations

Controller implementing business rules

Controller handling transactions

Best Practice

Controller delegates everything to service layer.

Service handles business logic.

Repository handles data.

DTO handles API communication.

Message for Reel

Controllers should be thin.

Business logic belongs to service layer.

Clean architecture starts here.

Duration

40 to 60 seconds.

Target Audience

Backend developers
Java developers
Software engineers
Architects
Tech leads