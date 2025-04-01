package com.bigcommerce.product.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseWebClient {

    private Product data;

    @Getter
    @Setter
    public static class Product {
        private Integer id;
        private String name;
        private String type;
        private String sku;
        private String description;
        private Integer weight;
        private Integer width;
        private Integer depth;
        private Integer height;
        private Double price;
        private Integer cost_price;
        private Integer retail_price;
        private Integer sale_price;
        private Integer map_price;
        private Integer tax_class_id;
        private List<Integer> categories;
        private Integer brand_id;
    }

}
