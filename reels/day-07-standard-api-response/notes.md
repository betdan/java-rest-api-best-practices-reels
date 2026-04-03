Concepto clave

Las APIs deben devolver respuestas consistentes.

Problema

Respuestas diferentes en cada endpoint.

Solución

ApiResponse estándar.

Campos recomendados

status
message
data
timestamp
path
errors (opcional)
traceId (opcional)

Buenas prácticas

Siempre usar ResponseEntity<ApiResponse<T>>
Mantener mismo contrato en toda la API
Integrar con GlobalExceptionHandler
Incluir timestamp
Incluir mensaje claro

Beneficio principal

Contratos estables entre backend y frontend.