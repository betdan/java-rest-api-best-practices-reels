// ❌ Bad Practice - Always returning 200 OK

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {

        if (id == 10) {
            return ResponseEntity.ok("User not found");
        }

        return ResponseEntity.ok(new User(1L, "John", "john@email.com"));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {

        if (user.getName() == null) {
            return ResponseEntity.ok("Invalid request");
        }

        return ResponseEntity.ok("User created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        return ResponseEntity.ok("User deleted");
    }
}

// ✅ Good Practice - Proper HTTP Status Codes

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(
            @PathVariable Long id) {

        if (id == 10) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        UserResponseDto user =
                new UserResponseDto(1L, "John", "john@email.com");

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @RequestBody CreateUserRequestDto request) {

        if (request.getName() == null) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }

        UserResponseDto created =
                new UserResponseDto(1L, request.getName(), request.getEmail());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id) {

        return ResponseEntity.noContent().build();
    }
}