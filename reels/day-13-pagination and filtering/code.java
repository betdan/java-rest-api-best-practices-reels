package com.example.api;

// ❌ BAD PRACTICE

@RestController
@RequestMapping("/api/orders")
class OrderController {

```
@GetMapping
public List<Order> getOrders() {
    return orderService.findAll();
}
```

}

// ✅ GOOD PRACTICE

@RestController
@RequestMapping("/api/orders")
class OrderController {

```
@GetMapping
public Page<Order> getOrders(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String status) {

    return orderService.findOrders(page, size, status);
}
```

}
