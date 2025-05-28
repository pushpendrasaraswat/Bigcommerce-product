FROM openjdk:23-jdk-slim

ADD build/libs/product-consumer-0.0.1-SNAPSHOT.jar product-consumer-0.0.1-SNAPSHOT.jar

EXPOSE 8082
# Set environment variables
ENV API_PATH=https://api.bigcommerce.com/stores/jinm0u387s/v3/ \
    ACCESS_TOKEN=bvz3t7797no0ws4d0fdqj9tkmhaady6 \
    CLIENT_NAME=Bigcommerce-connection \
    CLIENT_ID=qem22lalezzw11ybbeq4r1koz02xbwf \
    CLIENT_SECRET=b017a9ea83e2c2794d86f5e8a883bc2092735cd909245f0d9c6c96346d89b8f5 \
    GRAPHQL_PATH=https://psepamlearning.mybigcommerce.com/graphql



ENTRYPOINT ["java", "-jar", "product-consumer-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]