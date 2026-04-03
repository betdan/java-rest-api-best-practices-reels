Título: HTTP Status Codes

Duración: 45 a 60 segundos

Nunca devuelvas 200 OK para todo.

Los códigos HTTP son parte del contrato de la API.

200 significa éxito.

No errores.

No fallos.

No not found.

Enfoque incorrecto:

200 OK para errores.

Enfoque correcto:

200 OK para éxito.

201 CREATED para nuevos recursos.

204 NO CONTENT para eliminar.

400 BAD REQUEST para entrada inválida.

404 NOT FOUND para datos inexistentes.

Los códigos HTTP comunican el comportamiento del sistema.

Mejoran la claridad de la API.

Mejoran la integración.

Mejoran la confiabilidad.

Tu API debe hablar HTTP correctamente.

Sígueme para más buenas prácticas de Java REST API.