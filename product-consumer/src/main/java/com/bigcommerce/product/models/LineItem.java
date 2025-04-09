package com.bigcommerce.product.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem {
    public int quantity;
    public int product_id;
    public int list_price;
    public int variant_id;
    public String name;
    public List<OptionSelection> option_selections;
}
