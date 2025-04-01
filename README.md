# This Project has two project 
1. Product Producer
2. Product Consumer

 ## Product Producer 
 To setup this project you need docker available on your machine, run the docker-compose file and start the spring boot server.
you need to use following url to push data into kafka.

curl command 
curl --request POST \
  --url http://localhost:8080/product \
  --header 'content-type: application/json' \
  --data '{
  "name":"sample-2",
  "type": "DIGITAL",
  "description":"this is a sample product 2",
  "weight":1000,
  "width":2000,
  "price":23.5
}'

 ## Product Consumer 
To setup consumer just start the spring boot server , please make sure kafka is up and running .

Consumer will read the message and try to create that product in big commerce, please validate if product is created in Big commerce.

Consumer has 2 editional ednpoint 
1. Get product data from bigcommerce using webclient
curl --request GET \
  --url http://localhost:8082/product/122

   
2. get product data from bigcommerce using Graphql
curl --request GET \
  --url https://api.bigcommerce.com/stores/jinm0u387s/v3/catalog/products/122 \
  --header 'content-type: application/json' \
  --header 'x-auth-token: bvz3t7797no0ws4d0fdqj9tkmhaady6' \
  --data '{"query":"query productById($productId: Int!) {\n  site {\n    product(entityId: $productId) {\n      id\n      entityId\n      name\n      plainTextDescription\n      defaultImage {\n        ...ImageFields\n      }\n      images {\n        edges {\n          node {\n            ...ImageFields\n          }\n        }\n      }\n      customFields {\n        edges {\n          node {\n            ...CustomField\n          }\n        }\n      }\n      reviewSummary {\n        summationOfRatings\n        numberOfReviews\n      }\n      prices {\n        price {\n          ...MoneyFields\n        }\n        priceRange {\n          min {\n            ...MoneyFields\n          }\n          max {\n            ...MoneyFields\n          }\n        }\n        salePrice {\n          ...MoneyFields\n        }\n        retailPrice {\n          ...MoneyFields\n        }\n        saved {\n          ...MoneyFields\n        }\n        bulkPricing {\n          minimumQuantity\n          maximumQuantity\n          ... on BulkPricingFixedPriceDiscount {\n            price\n          }\n          ... on BulkPricingPercentageDiscount {\n            percentOff\n          }\n          ... on BulkPricingRelativePriceDiscount {\n            priceAdjustment\n          }\n        }\n      }\n      brand {\n        name\n      }\n    }\n  }\n}\n\nfragment ImageFields on Image {\n  url320wide: url(width: 320)\n  url640wide: url(width: 640)\n  url960wide: url(width: 960)\n  url1280wide: url(width: 1280)\n}\n\nfragment MoneyFields on Money {\n  value\n  currencyCode\n}\n\nfragment CustomField on CustomField {\n  name\n  value\n}"}'

## Set up environment variable 
check application.yml file in both the projects and setup environment variables accordingly.
