package com.bigcommerce.product.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bigcommerce.product.models.CartRequest;
import com.bigcommerce.product.models.CartResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BigcommerceCartService {

    Logger logger = LoggerFactory.getLogger(BigcommerceCartService.class);
    private final WebClient webClient;


    public CartResponse createCartInBigcommerce(CartRequest request) {
        CartResponse response = webClient.post().uri("carts").bodyValue(request).retrieve().bodyToMono(CartResponse.class).block();
        logger.info(response.toString());
        return response;
    }

    public CartResponse getCart(String cartId) {
        return webClient.get().uri("carts/" + cartId).retrieve().bodyToMono(CartResponse.class).block();
    }
}
