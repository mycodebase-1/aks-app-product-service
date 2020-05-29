
This is a simple Spring boot microservice which is dockerized. This application is dependent on CosmosDB to retrieve the product data.

## Pre requisite:
 - Azure CosmodDB account created. CosmosDB credentials are loaded into AKS sercrets. If this is not done already, follow the step below:
 - Create a new Service Connection in Devops pipeline. Name it - aks-sc
 - Infrastructure pipelines are created

## Add the CosmodDB account credentials to AKS Secrets
Copy the URI and primary key from CosmodDB account keys.
In the below command, replace:
- <<COSMOSDB_URI>> with the URI of cosmos DB account
- <<COSMOSDB_KEY>> with the primary key of cosmos DB account
```
kubectl create configmap product-service-cosmosdb-uri --from-literal=azure.cosmosdb.uri=<<COSMOSDB_URI>> --from-literal=azure.cosmosdb.database=product-service

kubectl create secret generic product-service-cosmos-key --from-literal=azure.cosmosdb.key=<<COSMODDB_KEY>>
```

## Execute the pipeline in Azure DevOps
