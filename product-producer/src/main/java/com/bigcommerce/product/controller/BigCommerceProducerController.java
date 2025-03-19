package com.bigcommerce.product.controller;

import com.bigcommerce.product.dao.BigCommerceProduct;
import com.bigcommerce.product.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class BigCommerceProducerController {

    ProductService productService;

    @PostMapping()
    @ResponseBody
    BigCommerceProduct createProduct(@RequestBody BigCommerceProduct product) {
        productService.createProduct(product);
        return product;
    }
}
