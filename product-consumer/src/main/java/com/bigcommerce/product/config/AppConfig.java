package com.bigcommerce.product.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

import com.bigcommerce.product.constants.BigCommerceConstant;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    @Value("${bigcommerce.connection.access_token}")
    private String accessToken;

    @Value("${bigcommerce.connection.graphql_path}")
    private String graphQlPath;

    @Value("${bigcommerce.connection.api_url}")
    private String apiPath;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
            .baseUrl(apiPath)
            .defaultHeader(BigCommerceConstant.TOKEN_HEADER, accessToken)
            .defaultHeader("Content-Type", "application/json")
            .defaultHeader("Accept", "application/json")
            .build();
    }


    @Bean
    public HttpGraphQlClient graphQlClient() {

        WebClient webClient = WebClient.builder().baseUrl(graphQlPath).defaultHeader("Authorization", "Bearer" + getWebToken()).build();

        return HttpGraphQlClient.builder(webClient).build();
    }

    private String getWebToken() {
        TokenData tokenData = TokenData.builder().allowedCorsOrigins(List.of("http://localhost:8080")).channel_id(1).expires_at(1885635176).build();

        TokenResponse response = webClient().post().uri("storefront/api-token").bodyValue(tokenData).retrieve().bodyToMono(TokenResponse.class).block();

        if (null != response && null != response.getData()) {
            return response.getData().getToken();
        } else {
            return null;
        }
    }
}
