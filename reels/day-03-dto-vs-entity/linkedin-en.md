Java REST API Best Practice #3

DTO vs Entity

Never return Entities directly from Controllers.

Entities represent your database.

DTOs represent your API.

Wrong approach:

Controller → Entity → Client

This exposes:

• passwords
• internal fields
• database structure
• sensitive data
• unnecessary information

Correct approach:

Controller → DTO → Client

DTOs allow you to:

• control responses
• hide sensitive fields
• protect domain models
• simplify API contracts
• decouple database from API
• improve security

Entities belong to the persistence layer.

DTOs belong to the API layer.

This separation creates safer and cleaner APIs.

Full GitHub repository in the first comment.

#java
#springboot
#restapi
#backend
#softwarearchitecture
#cleanarchitecture
#microservices
#engineering