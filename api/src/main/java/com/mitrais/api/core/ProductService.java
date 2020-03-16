package com.mitrais.api.core;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

public interface ProductService {
    Product createProduct(@RequestBody Product body);

    @GetMapping(
        value = "/product/{productId}",
        produces = "application/json"
    )
    Mono<Product> getProduct(
        @RequestHeader HttpHeaders headers,
        @PathVariable int productId,
        @RequestParam(value = "faultPercent", required = false, defaultValue = "0") int faultPercent
    );

    void deleteProduct(@PathVariable int productId);
}
