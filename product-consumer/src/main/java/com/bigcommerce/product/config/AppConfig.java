package com.bigcommerce.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.bigcommerce.product.constants.BigCommerceConstant;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    @Value("${bigcommerce.connection.API_PATH}")
    private String apiPath;

    @Value("${bigcommerce.connection.ACCESS_TOKEN}")
    private String accessToken;


    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(apiPath).defaultHeader(BigCommerceConstant.TOKEN_HEADER, accessToken).build();
    }
}
