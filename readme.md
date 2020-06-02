
This is a simple Spring boot microservice which is dockerized. This version of the app is using in-memory database. 
To use the app using CosmodDB database, checkout the cosmosdb branch from this repo.

## Pre requisite:
 - Ensure the Kubernetes service connection is created for pipeline.
 - Ensure the ACR service connection is created for pipeline.
 - Infrastructure pipelines are created

## Execute the pipeline in Azure DevOps


### Login to AKS
```
az aks get-credentials --resource-group <<RES_GROUP>> --name <<AKS_NAME>>
```