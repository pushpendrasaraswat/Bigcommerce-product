package com.bigcommerce.product.config;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenData {
    private List<String> allowedCorsOrigins;
    private int channel_id;
    private long expires_at;

}
