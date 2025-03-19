package com.bigcommerce.product.dao;

import lombok.Data;

@Data
public class BigCommerceProduct {
    String name;
    ProductType type;
    String description;
    Integer weight;
    Integer width;
    double price;
}
