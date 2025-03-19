package com.bigcommerce.product.consumer;


import com.bigcommerce.product.service.BigcommerceProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bigcommerce.product.event.ProductCreatedEvent;

@Service
@RequiredArgsConstructor
public class ProductConsumer {

    private final BigcommerceProductService bigcommerceProductService;


    @KafkaListener(topics = "bigcommerce_product", groupId = "bigcommerce_product")
    public void consume(ProductCreatedEvent message) {
        System.out.println("Consumed message: " + message);
        bigcommerceProductService.createProductInBigCommerce(message);
    }

}
