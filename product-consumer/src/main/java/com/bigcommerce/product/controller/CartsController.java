package com.bigcommerce.product.controller;


import org.springframework.web.bind.annotation.*;

import com.bigcommerce.product.models.CartRequest;
import com.bigcommerce.product.models.CartResponse;
import com.bigcommerce.product.service.BigcommerceCartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(("cart"))
@RequiredArgsConstructor
public class CartsController {

    private final BigcommerceCartService cartService;

    @PostMapping
    @ResponseBody
    CartResponse createCart(@RequestBody CartRequest cartRequest) {
        return cartService.createCartInBigcommerce(cartRequest);
    }

    @GetMapping("/{cartId}")
    @ResponseBody
    CartResponse createCart(@PathVariable String cartId) {
        return cartService.getCart(cartId);
    }
}
