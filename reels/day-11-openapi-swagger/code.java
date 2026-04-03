// ❌ BAD PRACTICE - No API Documentation

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(new Order(id, "Laptop", 1200));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(order);
    }
}

// ✅ GOOD PRACTICE - OpenAPI Swagger Configuration

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order API")
                        .version("1.0")
                        .description("Professional REST API documentation")
                        .contact(new Contact()
                                .name("API Team")
                                .email("api@company.com")));
    }
}

// ✅ GOOD PRACTICE - Documented Controller

@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Orders", description = "Order management APIs")
public class OrderController {

    @Operation(summary = "Get order by id",
               description = "Retrieve a specific order by its identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {

        Order order = new Order(id, "Laptop", 1200);

        return ResponseEntity.ok(order);
    }

    @Operation(summary = "Create new order")
    @ApiResponse(responseCode = "201", description = "Order created")
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}

// ✅ Dependency (pom.xml)

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>