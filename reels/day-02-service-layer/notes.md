Day 02 - Service Layer

Objetivo del reel:

Enseñar que la lógica de negocio no debe ir en el Controller
y debe centralizarse en el Service Layer.

Concepto clave:

Service Layer = Business Logic

Mensaje principal:

Controllers handle HTTP
Services handle business logic
Repositories handle data

Comparación visual:

Bad

Controller → Repository

Good

Controller → Service → Repository

Puntos que deben explicarse:

1. Controller no debe tomar decisiones
2. Service contiene reglas
3. Repository solo accede a datos
4. Service puede reutilizarse
5. Service facilita testing
6. Service permite escalabilidad

Duración estimada:

45 a 60 segundos

Tipo de contenido:

Reel técnico educativo

Estilo visual:

Dark theme
Code comparison
Left bad
Right good
Minimalist tech style