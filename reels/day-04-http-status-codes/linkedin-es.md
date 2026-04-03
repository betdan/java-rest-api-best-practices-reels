Java REST API Best Practice #4

HTTP Status Codes

Nunca devuelvas 200 OK para todo.

Los códigos HTTP son parte del contrato de la API.

Enfoque incorrecto:

200 OK para éxito  
200 OK para errores  
200 OK para not found  

Esto genera confusión en los clientes.

Enfoque correcto:

200 OK → Solicitud exitosa  
201 CREATED → Recurso creado  
204 NO CONTENT → Recurso eliminado  
400 BAD REQUEST → Entrada inválida  
404 NOT FOUND → Recurso no encontrado  
500 INTERNAL SERVER ERROR → Error inesperado  

Los códigos HTTP comunican el resultado de la solicitud.

Mejoran:

• claridad de la API
• integración de clientes
• manejo de errores
• confiabilidad del sistema
• experiencia del desarrollador

Tu API debe hablar HTTP correctamente.

Repositorio completo en el primer comentario.

#java
#springboot
#restapi
#backend
#softwarearchitecture
#cleanarchitecture
#microservices
#engineering