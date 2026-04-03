package com.example.api;

// ❌ BAD PRACTICE

@Service
class OrderService {

```
public Order create(OrderRequest request) {
    return orderRepository.save(new Order(request));
}
```

}

// ✅ GOOD PRACTICE

@SpringBootTest
class OrderServiceTest {

```
@Autowired
private OrderService orderService;

@Test
void shouldCreateOrder() {

    OrderRequest request = new OrderRequest("user1");

    Order result = orderService.create(request);

    assertNotNull(result);
    assertEquals("user1", result.getUserId());
}
```

}
