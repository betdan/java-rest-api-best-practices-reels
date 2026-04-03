// ❌ BAD PRACTICE - No API Versioning

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return new Order(id, "Laptop", 1200);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return order;
    }
}

// ✅ GOOD PRACTICE - URI Versioning

@RestController
@RequestMapping("/api/v1/orders")
public class OrderControllerV1 {

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok("Order V1");
    }
}

// ✅ GOOD PRACTICE - New Version

@RestController
@RequestMapping("/api/v2/orders")
public class OrderControllerV2 {

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok("Order V2 with new structure");
    }
}

// ✅ Alternative - Header Versioning

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping(value = "/{id}", headers = "X-API-VERSION=1")
    public ResponseEntity<String> getOrderV1(@PathVariable Long id) {
        return ResponseEntity.ok("Order version 1");
    }

    @GetMapping(value = "/{id}", headers = "X-API-VERSION=2")
    public ResponseEntity<String> getOrderV2(@PathVariable Long id) {
        return ResponseEntity.ok("Order version 2");
    }
}