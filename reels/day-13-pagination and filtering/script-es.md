Día 13 – Paginación y filtrado en APIs.

Un error común es devolver todos los registros en una sola petición.

Esto genera respuestas grandes, consultas lentas y problemas de escalabilidad.

Un mejor enfoque es usar paginación y filtrado.

En lugar de devolver todo, la API retorna conjuntos pequeños de datos.

Por ejemplo:

GET /api/orders?page=0&size=10&status=PAID

Esto mejora el rendimiento y mantiene la API escalable.

La paginación y el filtrado son esenciales en APIs productivas.
