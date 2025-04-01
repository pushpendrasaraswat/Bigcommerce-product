package com.bigcommerce.product.config;

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
        return WebClient.builder().baseUrl(apiPath).defaultHeader(BigCommerceConstant.TOKEN_HEADER, accessToken).build();
    }


    @Bean
    public HttpGraphQlClient graphQlClient() {

        WebClient webClient = WebClient.builder()
            .baseUrl(graphQlPath)
            .defaultHeader(
                "Authorization",
                "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJFUzI1NiJ9.eyJjaWQiOlsxXSwiY29ycyI6WyJodHRwczovL2RldmVsb3Blci5iaWdjb21tZXJjZS5jb20iXSwiZWF0IjoxNzQzNjYwODcxLCJpYXQiOjE3NDM0ODgwNzEsImlzcyI6IkJDIiwic2lkIjoxMDAzMzM5MDM1LCJzdWIiOiJCQyIsInN1Yl90eXBlIjowLCJ0b2tlbl90eXBlIjoxfQ.TDdr3RrBm4zgeu13ybeoj63qXmIir0kAVH699qIVwtutOkKLKzyOyH-kQztct_ADr8m87RlfNcmeudtqQjpS3Q")
            .build();

        return HttpGraphQlClient.builder(webClient).build();
    }
}
