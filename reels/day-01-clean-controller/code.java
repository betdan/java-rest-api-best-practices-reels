// ❌ Bad Practice - Fat Controller with business logic and repository access

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

        if (order.getAmount() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        order.setStatus("CREATED");
        order.setCreatedAt(LocalDateTime.now());

        Order saved = orderRepository.save(order);

        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {

        Optional<Order> order = orderRepository.findById(id);

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(order.get());
    }
}

// ✅ Good Practice - Clean Controller delegating to Service Layer

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(
            @RequestBody CreateOrderRequestDto request) {

        OrderResponseDto response = orderService.createOrder(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(
            @PathVariable Long id) {

        OrderResponseDto response = orderService.getOrderById(id);

        return ResponseEntity.ok(response);
    }
}