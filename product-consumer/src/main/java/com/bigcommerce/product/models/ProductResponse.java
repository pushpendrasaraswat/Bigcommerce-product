package com.bigcommerce.product.models;

import java.util.List;

import lombok.Getter;

@Getter
public class ProductResponse {
    private Data data;

    @Getter
    public static class Data {
        private Site site;
    }

    @Getter
    public static class Site {
        private Product product;
    }

    @Getter
    public static class Product {
        private String id;
        private int entityId;
        private String name;
        private String plainTextDescription;
        private DefaultImage defaultImage;
        private Images images;
        private CustomFields customFields;
        private ReviewSummary reviewSummary;
        private Prices prices;
        private VariantsResponse variants;
        private Brand brand;
    }

    @Getter
    public static class DefaultImage {
        private String url320wide;
        private String url640wide;
        private String url960wide;
        private String url1280wide;
    }

    @Getter
    public static class Images {
        private List<ImageEdge> edges;
    }

    @Getter
    public static class ImageEdge {
        private ImageNode node;
    }

    @Getter
    public static class ImageNode {
        private String url320wide;
        private String url640wide;
        private String url960wide;
        private String url1280wide;
    }

    @Getter
    public static class CustomFields {
        private List<Object> edges;
    }

    @Getter
    public static class ReviewSummary {
        private int summationOfRatings;
        private int numberOfReviews;
    }

    @Getter
    public static class Prices {
        private Price price;
        private PriceRange priceRange;
        private Price salePrice;
        private Price retailPrice;
        private Price saved;
        private List<Object> bulkPricing;
    }

    @Getter
    public static class Price {
        private double value;
        private String currencyCode;
    }

    @Getter
    public static class PriceRange {
        private Price min;
        private Price max;
    }

    @Getter
    public static class VariantsResponse {
        private List<VariantEdge> edges;
    }

    @Getter
    public static class VariantEdge {
        private VariantNode node;
    }

    @Getter
    public static class VariantNode {
        private String id;
        private int entityId;
        private String sku;
        private Weight weight;
        private DefaultImage defaultImage;
    }

    @Getter
    public static class Weight {
        private String unit;
        private double value;
    }

    @Getter
    public static class Brand {
        private String name;
    }
}
