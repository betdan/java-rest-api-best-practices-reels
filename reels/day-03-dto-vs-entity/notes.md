Day 03 - DTO vs Entity

Objetivo del reel:

Enseñar que las Entities no deben exponerse en la API
y que los DTOs deben usarse para controlar la respuesta.

Concepto clave:

Entity = Database
DTO = API

Mensaje principal:

Never expose Entities
Always use DTOs

Comparación visual:

Bad

Controller → Entity → Client

Good

Controller → DTO → Client

Problema:

Entity contiene password
Entity contiene campos internos
Entity contiene estructura de BD

Solución:

DTO controla qué se expone

Beneficios:

Security
Clean API
Decoupling
Better contracts
Safer responses

Duración:

45 a 60 segundos

Estilo:

Dark theme
Left bad
Right good
Code comparison
Minimalist tech