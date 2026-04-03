🚀 Día 14 – Estrategia de Caché en APIs

Un error común en APIs es consultar la base de datos en cada petición.

❌ Consultas repetidas
❌ Respuestas lentas
❌ Alta carga en la base de datos
❌ Bajo rendimiento

Mal enfoque:

Cliente → API → Base de datos (cada request)

Incluso para datos que se consultan constantemente.

✅ Buen enfoque:

Cliente → API → Caché → Base de datos

La API primero revisa la caché y solo consulta la base si es necesario.

Beneficios:

✔ Respuestas más rápidas
✔ Menor carga en la base de datos
✔ Mejor rendimiento
✔ APIs escalables
✔ Mejor experiencia de usuario

El caché es clave para APIs de alto rendimiento en producción.

#ArquitecturaDeSoftware #Java #SpringBoot #Caching #Backend #APIDesign #Performance
