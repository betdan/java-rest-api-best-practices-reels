🚀 Día 13 – Paginación y Filtrado en APIs

Un error común en APIs es devolver todos los registros en una sola petición.

❌ Respuestas grandes
❌ Consultas lentas
❌ Alto uso de memoria
❌ Baja escalabilidad

Mal enfoque:

GET /api/orders → devuelve todas las órdenes

Esto se vuelve peligroso cuando la base de datos crece.

✅ Buen enfoque:

GET /api/orders?page=0&size=10&status=PAID

Beneficios:

✔ Respuestas más rápidas
✔ Payloads pequeños
✔ Mejor rendimiento
✔ APIs escalables
✔ Control de datos

La paginación y el filtrado son esenciales en APIs productivas.

#ArquitecturaDeSoftware #Java #SpringBoot #Backend #APIDesign #Microservicios #CleanCode
