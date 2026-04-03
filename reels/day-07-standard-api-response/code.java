// ❌ BAD PRACTICE - Inconsistent API Responses

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return new Order(id, "Laptop", 1200);
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        return "Order created";
    }

    @DeleteMapping("/{id}")
    public boolean deleteOrder(@PathVariable Long id) {
        return true;
    }
}

// ✅ GOOD PRACTICE - Standard API Response

public class ApiResponse<T> {

    private String status;
    private String message;
    private T data;
    private String timestamp;

    public ApiResponse(String status, String message, T data, String timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    // getters and setters
}

// ✅ Standard Response Usage

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrder(@PathVariable Long id) {

        Order order = new Order(id, "Laptop", 1200);

        ApiResponse<Order> response = new ApiResponse<>(
                "success",
                "Order retrieved successfully",
                order,
                LocalDateTime.now().toString()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createOrder(@RequestBody Order order) {

        ApiResponse<String> response = new ApiResponse<>(
                "success",
                "Order created successfully",
                "ORDER_CREATED",
                LocalDateTime.now().toString()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}