Day 05 - Global Exception Handling

Objetivo:

Enseñar centralización de errores.

Concepto clave:

Controllers should not handle exceptions

Mensaje principal:

Throw exceptions
Handle globally

Comparación:

Bad

try catch in controller

Good

@RestControllerAdvice

Arquitectura:

Controller → Exception → Global Handler → HTTP Response

Beneficios:

Clean controllers
Centralized error handling
Consistent responses
Better maintenance
Scalable APIs

Duración:

45 a 60 segundos

Estilo:

Dark theme
Left bad
Right good
Code comparison
Modern tech
Minimalist