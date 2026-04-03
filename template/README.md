# Java REST API Template

Minimal `Java 21 + Spring Boot` template designed to demonstrate the 16 reels topics on top of one clean API.

## Goal

Keep the project small while still showing:

- Layered architecture
- Clean controller boundaries
- DTOs, validation, and responses
- Security, logging, async, caching, and testing
- A production-ready structure without unnecessary complexity

## Structure

- `controller`: HTTP layer
- `service`: business use cases
- `repository`: persistence layer
- `dto`: request and response contracts
- `entity`: JPA entities
- `mapper`: entity-to-dto mapping
- `response`: standard API wrappers
- `exception`: centralized error handling
- `config`: security, OpenAPI, async, cache, seed data

## Covered Endpoints

- `POST /api/v1/users`
- `GET /api/v1/users/{id}`
- `GET /api/v1/users?page=0&size=10&name=...`
- `POST /api/v1/users/{id}/welcome-email`

## How The 16 Days Map Here

1. Clean Controller: `UserController`
2. Service Layer: `UserService`
3. DTO vs Entity: `dto` and `entity`
4. HTTP Status Codes: `200`, `201`, `202`, `400`, `404`
5. Global Exception Handling: `GlobalExceptionHandler`
6. Validation: Jakarta validation annotations
7. Standard API Response: `ApiResponse`
8. API Versioning: `/api/v1`
9. Logging Best Practices: structured service logs
10. Security Best Practices: `SecurityConfig`
11. OpenAPI / Swagger: `OpenApiConfig`
12. Async Processing: `NotificationService`
13. Pagination and Filtering: list users endpoint
14. Caching Strategy: `@Cacheable` in `UserService`
15. Testing APIs: controller and service tests
16. Production Ready Architecture: package separation and config design

## Run

```bash
mvn spring-boot:run
```

Swagger UI:

- `/swagger-ui.html`

H2 Console:

- `/h2-console`

Default demo credentials:

- Username: `admin`
- Password: `admin123`


---------------------------------


## Version en Espanol

Template minimo en `Java 21 + Spring Boot` disenado para demostrar los 16 temas de la serie de reels sobre una sola API limpia.

## Objetivo

Mantener el proyecto pequeno, pero capaz de mostrar:

- Arquitectura por capas
- Controllers limpios
- DTOs, validaciones y respuestas estandar
- Seguridad, logging, asincronia, cache y testing
- Una estructura lista para produccion sin complejidad innecesaria

## Estructura

- `controller`: capa HTTP
- `service`: casos de uso y logica de negocio
- `repository`: capa de persistencia
- `dto`: contratos de request y response
- `entity`: entidades JPA
- `mapper`: conversion entre entidades y DTOs
- `response`: respuestas estandar de la API
- `exception`: manejo centralizado de errores
- `config`: seguridad, OpenAPI, async, cache y datos semilla

## Endpoints Cubiertos

- `POST /api/v1/users`
- `GET /api/v1/users/{id}`
- `GET /api/v1/users?page=0&size=10&name=...`
- `POST /api/v1/users/{id}/welcome-email`

## Como Se Cubren Los 16 Dias

1. Clean Controller: `UserController`
2. Service Layer: `UserService`
3. DTO vs Entity: `dto` y `entity`
4. HTTP Status Codes: `200`, `201`, `202`, `400`, `404`
5. Global Exception Handling: `GlobalExceptionHandler`
6. Validation: anotaciones de Jakarta Validation
7. Standard API Response: `ApiResponse`
8. API Versioning: `/api/v1`
9. Logging Best Practices: logs estructurados en servicios
10. Security Best Practices: `SecurityConfig`
11. OpenAPI / Swagger: `OpenApiConfig`
12. Async Processing: `NotificationService`
13. Pagination and Filtering: endpoint de listado de usuarios
14. Caching Strategy: `@Cacheable` en `UserService`
15. Testing APIs: pruebas de controller y service
16. Production Ready Architecture: separacion por paquetes y configuracion clara

## Ejecutar

```bash
mvn spring-boot:run
```

Swagger UI:

- `/swagger-ui.html`

Consola H2:

- `/h2-console`

Credenciales demo:

- Usuario: `admin`
- Contrasena: `admin123`