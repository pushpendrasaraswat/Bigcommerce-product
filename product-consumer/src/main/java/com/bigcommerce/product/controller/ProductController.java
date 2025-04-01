package com.bigcommerce.product.controller;

import static com.bigcommerce.product.models.ProductResponse.Product;

import java.io.IOException;

import org.springframework.web.bind.annotation.*;

import com.bigcommerce.product.models.ProductResponseWebClient;
import com.bigcommerce.product.service.BigcommerceProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final BigcommerceProductService bigcommerceProductService;

    @GetMapping("/{productId}/graphql")
    @ResponseBody
    Product getProductByProductIdGraphql(@PathVariable String productId) throws IOException {
        return bigcommerceProductService.getProductByProductId(productId);
    }

    @GetMapping("/{productId}")
    @ResponseBody
    ProductResponseWebClient.Product getProductByProductId(@PathVariable String productId) throws IOException {
        return bigcommerceProductService.getProductByProductIdUsingWebClient(productId);
    }
}
