package com.bigcommerce.product.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {
    String name;
    String type;
    String description;
    Integer weight;
    Integer width;
    double price;
}
