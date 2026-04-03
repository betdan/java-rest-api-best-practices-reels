Day 06 - Validation Layer

Objetivo:

Enseñar que la validación debe ser declarativa.

Concepto clave:

Manual validation is bad
Bean validation is better

Mensaje principal:

Use @Valid

Comparación:

Bad

if validation in controller

Good

@NotBlank
@Email
@Size

Arquitectura:

Controller → @Valid → Request DTO → Validation

Beneficios:

Clean controllers
Reusable rules
Centralized validation
Better API design

Duración:

45 a 60 segundos

Estilo:

Dark theme
Left bad
Right good
Code comparison
Modern minimalist