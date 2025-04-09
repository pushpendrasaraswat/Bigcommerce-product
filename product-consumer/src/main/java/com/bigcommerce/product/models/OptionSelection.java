package com.bigcommerce.product.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionSelection {
    public int option_id;
    public int option_value;
    public String name;
    public String value;
}
