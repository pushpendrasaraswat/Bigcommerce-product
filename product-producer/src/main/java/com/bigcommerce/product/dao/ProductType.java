package com.bigcommerce.product.dao;

public enum ProductType {
    PHYSICAL("physical"),
    DIGITAL("digital");

    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
