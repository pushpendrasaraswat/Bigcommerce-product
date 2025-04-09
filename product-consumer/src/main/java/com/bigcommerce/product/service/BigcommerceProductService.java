package com.bigcommerce.product.service;


import static com.bigcommerce.product.models.ProductResponse.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bigcommerce.product.event.ProductCreatedEvent;
import com.bigcommerce.product.models.ProductResponse;
import com.bigcommerce.product.models.ProductResponseWebClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BigcommerceProductService {

    Logger logger = LoggerFactory.getLogger(BigcommerceProductService.class);
    private final HttpGraphQlClient graphQlClient;

    private final WebClient webClient;

    public void createProductInBigCommerce(ProductCreatedEvent productCreatedEvent) {
        Map response = webClient.post().uri("catalog/products").bodyValue(productCreatedEvent).retrieve().bodyToMono(Map.class).block();
        logger.info(response.toString());
    }

    /**
     * This methods reads the schema for the Grpahql and uses that for query
     *
     * @param path
     * @return file
     */
    private String readGraphQLQuery(String path) throws IOException {
        Path filePath = new ClassPathResource(path).getFile().toPath();
        return Files.readString(filePath);
    }

    /**
     * This method fetches Product details using graphql method provided by bigcommerce
     *
     * @param productId
     * @return Product
     */
    public Product getProductByProductId(String productId) throws IOException {
        String productQuery = readGraphQLQuery("graphql/productById.graphql");

        return graphQlClient.document(productQuery)
            .variable("productId", Integer.valueOf(productId))
            .retrieve("site.product")
            .toEntity(ProductResponse.Product.class) // Get full JSON response
            .block();
    }

    /**
     * this method calles rest end point of bgcommerce to get product details for the provided product id
     *
     * @return ProductResponseWebClient.Product
     */
    public ProductResponseWebClient.Product getProductByProductIdUsingWebClient(String productId) {
        ProductResponseWebClient response =
            webClient.get().uri("catalog/products/" + productId).retrieve().toEntity(ProductResponseWebClient.class).block().getBody();
        return response.getData();
    }

}
