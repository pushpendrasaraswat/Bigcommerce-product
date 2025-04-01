package com.bigcommerce.product.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TokenData {
    private List<String> allowedCorsOrigins;
    private int channel_id;
    private long expires_at;

}
