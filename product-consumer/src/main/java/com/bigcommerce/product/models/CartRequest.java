package com.bigcommerce.product.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
    public int customer_id;
    public List<LineItem> line_items;
    public int channel_id;
    public Currency currency;
    public String locale;
}
