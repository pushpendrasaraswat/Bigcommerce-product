package com.bigcommerce.product.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {
    private Data data;
    private Meta meta;

    @Getter
    @Setter
    public static class Data {
        private String token;
    }

    @Getter
    @Setter
    public static class Meta {

    }
}
