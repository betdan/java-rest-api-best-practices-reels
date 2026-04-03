// ❌ BAD PRACTICE - Monolithic Controller handling everything

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO orders VALUES (?)");
            ps.setString(1, order.getName());
            ps.executeUpdate();

            System.out.println("Order created");

            return ResponseEntity.ok(order);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error");
        }
    }
}

// ✅ GOOD PRACTICE - Production Ready Architecture

// Controller
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderDto>> create(@Valid @RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(ApiResponse.success(orderService.create(request)));
    }
}

// Service

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderDto create(CreateOrderRequest request) {
        logger.info("Creating order");

        Order order = repository.save(new Order(request.getName()));

        return new OrderDto(order.getId(), order.getName());
    }
}

// Global Exception Handler

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handle(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Internal error"));
    }
}

// Standard Response

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private String message;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, null, message);
    }
}