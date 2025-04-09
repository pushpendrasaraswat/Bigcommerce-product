package com.bigcommerce.product.models;

import java.util.Date;
import java.util.List;

@lombok.Data
public class CartResponse {
    private Data data;
    private Meta meta;
}


@lombok.Data
class Discount {
    private String id;
    private int discounted_amount;
}


@lombok.Data
class Data {
    private String id;
    private int customer_id;
    private int channel_id;
    private String email;
    private Currency currency;
    private boolean tax_included;
    private int base_amount;
    private int discount_amount;
    private int manual_discount_amount;
    private int cart_amount;
    private List<Coupon> coupons;
    private List<Discount> discounts;
    private LineItems line_items;
    private Date created_time;
    private Date updated_time;
    private String locale;
    private int version;
}


@lombok.Data
class Coupon {
    String code;
    String id;
    String coupon_type;
    int discounted_amount;
    String display_name;
}


@lombok.Data
class LineItems {
    private List<PhysicalItem> physical_items;
    private List<DigitalItem> digital_items;
    private List<GiftCertificate> gift_certificates;
    private List<Object> custom_items;
}


@lombok.Data
class CustomItem {
    String id;
    String sku;
    String name;
    String quantity;
    String list_price;
    int extended_list_price;
    String image_url;
}


@lombok.Data
class GiftCertificate {
    private String id;
    private String name;
    private String theme;
    private int amount;
    private boolean taxable;
    private Email sender;
    private Email recipient;
    private String message;
}


@lombok.Data
class Email {
    String name;
    String email;
}


@lombok.Data
class DigitalItem {
    private String id;
    private String parent_id;
    private int variant_id;
    private int product_id;
    private String sku;
    private String name;
    private String url;
    private int quantity;
    private boolean taxable;
    private String image_url;
    private List<Discount> discounts;
    private List<Coupon> coupons;
    private int discount_amount;
    private int coupon_amount;
    private int original_price;
    private int list_price;
    private int sale_price;
    private int extended_list_price;
    private int extended_sale_price;
    private boolean is_require_shipping;
    private boolean is_mutable;
    private boolean is_custom_price;
    private boolean added_by_promotion;
}


@lombok.Data
class Meta {
}


@lombok.Data
class PhysicalItem {
    private String id;
    private String parent_id;
    private int variant_id;
    private int product_id;
    private String sku;
    private String name;
    private String url;
    private int quantity;
    private boolean taxable;
    private String image_url;
    private List<Discount> discounts;
    private List<Coupon> coupons;
    private int discount_amount;
    private int coupon_amount;
    private int original_price;
    private int list_price;
    private int sale_price;
    private int extended_list_price;
    private int extended_sale_price;
    private boolean is_require_shipping;
    private boolean is_mutable;
    private boolean is_custom_price;
    private boolean added_by_promotion;
}
