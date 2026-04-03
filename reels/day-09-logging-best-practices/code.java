// ❌ BAD PRACTICE - Poor Logging

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {

        System.out.println("Getting order...");

        if (id == null) {
            System.out.println("Error: id is null");
        }

        return new Order(id, "Laptop", 1200);
    }
}

// ✅ GOOD PRACTICE - Structured Logging

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {

        log.info("Fetching order with id: {}", id);

        Order order = new Order(id, "Laptop", 1200);

        log.debug("Order retrieved successfully: {}", order);

        return ResponseEntity.ok(order);
    }
}

// ✅ GOOD PRACTICE - Service Layer Logging

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public Order getOrderById(Long id) {

        log.info("Searching order in database: {}", id);

        if (id == null) {
            log.error("Order id is null");
            throw new IllegalArgumentException("Order id cannot be null");
        }

        Order order = new Order(id, "Laptop", 1200);

        log.info("Order found: {}", order.getId());

        return order;
    }
}