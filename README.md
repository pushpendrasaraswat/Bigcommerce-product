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
  --url http://localhost:8082/product/122/graphql

## Set up environment variable 
check application.yml file in both the projects and setup environment variables accordingly.
