package com.bigcommerce.product.service;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bigcommerce.product.event.ProductCreatedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BigcommerceProductService {

    Logger logger = LoggerFactory.getLogger(BigcommerceProductService.class);

    private final WebClient webClient;

    public void createProductInBigCommerce(ProductCreatedEvent productCreatedEvent) {

        Map response = webClient.post()
                .uri("catalog/products").bodyValue(productCreatedEvent).retrieve().bodyToMono(Map.class).block();

        logger.info(response.toString());

    }

}
