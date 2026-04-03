Título: Validation Layer

Duración: 45 a 60 segundos

Nunca valides manualmente en los Controllers.

Los if por todas partes generan código desordenado.

if name es null.

if email es inválido.

if password es vacío.

Esto hace los Controllers difíciles de mantener.

Enfoque correcto:

Bean Validation.

Usa @Valid.

Usa @NotBlank.

Usa @Email.

Usa @Size.

La validación pertenece al modelo de request.

El Controller solo recibe datos validados.

Esto crea controladores limpios.

Esto crea reglas reutilizables.

Esto crea mejores APIs.

Usa Bean Validation.

Sígueme para más buenas prácticas de Java REST API.