Day 04 - HTTP Status Codes

Objetivo:

Enseñar que HTTP status codes son parte del contrato de la API.

Concepto clave:

HTTP communicates system behavior

Mensaje principal:

Never return 200 for everything

Comparación:

Bad

200 OK for errors

Good

200
201
204
400
404

Arquitectura:

Controller → Service → ResponseStatusException → HTTP Status

Beneficios:

Clear APIs
Better client integration
Better error handling
Professional REST design

Duración:

45 a 60 segundos

Estilo:

Dark theme
Left bad
Right good
HTTP table
Code comparison
Modern tech