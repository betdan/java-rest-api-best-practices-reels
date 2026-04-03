Día 12 – Procesamiento asíncrono en APIs.

Un error común en el diseño de APIs es procesar todo dentro del request.

Pagos, emails, inventario, reportes, todo de forma síncrona.

Esto bloquea la API y la hace lenta y difícil de escalar.

Un mejor enfoque es el procesamiento asíncrono.

La API envía el request a una cola y retorna 202 Accepted.

Los workers procesan las tareas en segundo plano.

Cliente a API, API a Cola, Cola a Worker, Worker a Servicios.

Esto hace que tu API sea más rápida, escalable y preparada para alto tráfico.

El procesamiento asíncrono es clave para microservicios y arquitecturas orientadas a eventos.
