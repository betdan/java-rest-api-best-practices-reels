package com.example.api;

// ❌ BAD PRACTICE

@RestController
@RequestMapping("/api/products")
class ProductController {

```
@GetMapping("/{id}")
public Product getProduct(@PathVariable Long id) {
    return productService.findById(id);
}
```

}

// ✅ GOOD PRACTICE

@RestController
@RequestMapping("/api/products")
class ProductController {

```
@GetMapping("/{id}")
@Cacheable(value = "products", key = "#id")
public Product getProduct(@PathVariable Long id) {
    return productService.findById(id);
}
```

}
