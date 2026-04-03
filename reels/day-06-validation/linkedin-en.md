Java REST API Best Practice #6

Validation Layer

Never validate requests manually inside Controllers.

Wrong approach:

if statements everywhere

if name is null  
if email is invalid  
if password is empty  

This creates:

• duplicated validation
• messy controllers
• hard maintenance
• inconsistent rules

Correct approach:

Bean Validation

@Valid

@NotBlank  
@Email  
@Size  

Validation belongs to the request model.

Controller only receives validated data.

Benefits:

• clean controllers
• centralized validation
• reusable rules
• consistent errors
• scalable architecture
• cleaner APIs

Validation should be declarative, not manual.

Full GitHub repository in the first comment.

#java
#springboot
#restapi
#backend
#softwarearchitecture
#cleanarchitecture
#microservices
#engineering