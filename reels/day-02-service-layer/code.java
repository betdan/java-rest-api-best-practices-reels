// ❌ Bad Practice - Business logic inside Controller

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
}

// ✅ Good Practice

@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public OrderResponse create(
        @RequestBody CreateOrderRequest request) {

        return orderService.createOrder(request);
    }
}

@Service
public class OrderService {

    public OrderResponse createOrder(CreateOrderRequest request) {

        if(request.getAmount() <= 0){
            throw new IllegalArgumentException("Invalid amount");
        }

        return repository.save(order);
    }
}

