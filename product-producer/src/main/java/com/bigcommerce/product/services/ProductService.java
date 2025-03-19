package com.bigcommerce.product.services;

import com.bigcommerce.product.dao.BigCommerceProduct;
import com.bigcommerce.product.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    @Value("${spring.kafka.template.topic-name}")
    private String topicName;

    public void createProduct(BigCommerceProduct product){
        ProductCreatedEvent productCreatedEvent=ProductCreatedEvent.builder()
                .name(product.getName())
                .description(product.getDescription())
                .type(product.getType().getValue())
                .weight(product.getWeight())
                .width(product.getWidth())
                .price(product.getPrice())
                .build();

        kafkaTemplate.send(topicName,product.getName(),productCreatedEvent);
    }


}
