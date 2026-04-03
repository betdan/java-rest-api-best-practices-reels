package com.example.api;

// ❌ BAD PRACTICE

@RestController
@RequestMapping("/api/orders")
class OrderController {

```
@PostMapping
public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {

    paymentService.process(request);
    emailService.send(request);
    inventoryService.update(request);
    reportService.generate(request);

    return ResponseEntity.ok("Order processed");
}
```

}

// ✅ GOOD PRACTICE

@RestController
@RequestMapping("/api/orders")
class OrderController {

```
private final QueueService queueService;

public OrderController(QueueService queueService) {
    this.queueService = queueService;
}

@PostMapping
public ResponseEntity<ApiResponse> createOrder(
        @RequestBody OrderRequest request) {

    queueService.send("order-created", request);

    return ResponseEntity.accepted()
            .body(new ApiResponse("Order processing started"));
}
```

}
