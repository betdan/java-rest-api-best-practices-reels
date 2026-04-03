Concepto clave

Logging estructurado.

Problema

System.out.println no es logging.

Solución

SLF4J + LoggerFactory.

Niveles

TRACE
DEBUG
INFO
WARN
ERROR

Buenas prácticas

No loguear contraseñas
No loguear tokens
No loguear datos sensibles
Usar logs en controller y service
Agregar traceId
Usar logs estructurados
Integrar con ELK

Stack recomendado

SLF4J
Logback
ELK
CloudWatch
Grafana Loki

Objetivo

Observabilidad completa del sistema.