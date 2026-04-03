// ❌ Bad Practice - Manual validation inside Controller

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody CreateUserRequest request) {

        if (request.getName() == null || request.getName().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("Name is required");
        }

        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("Email is required");
        }

        if (!request.getEmail().contains("@")) {
            return ResponseEntity
                    .badRequest()
                    .body("Invalid email");
        }

        UserResponseDto user =
                new UserResponseDto(1L, request.getName(), request.getEmail());

        return ResponseEntity.ok(user);
    }
}

// ✅ Good Practice - Bean Validation with @Valid

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @Valid @RequestBody CreateUserRequest request) {

        UserResponseDto user =
                new UserResponseDto(1L, request.getName(), request.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}

class CreateUserRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    // getters and setters
}