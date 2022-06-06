# Monnify Integration
This GitHub repo is a playground to practice Spring Boot and integration with Monnify.

## Introduction
- [Monnify](https://monnify.com/) is a payment gateway for businesses to accept payments from customers, either on a recurring or one-time basis. Monnify offers an easier, faster and cheaper way for businesses to get paid on their web and mobile applications using convenient payment methods for customers with the highest success rates obtainable in Nigeria.

## Docs
- In this repo [Monnify's APIs](https://teamapt.atlassian.net/wiki/spaces/MON/overview) are used.
- The APIs used are:
  - [Authorization](https://teamapt.atlassian.net/wiki/spaces/MON/pages/212008633/Authorization)
  - [Create invoices (using reserved accounts)](https://teamapt.atlassian.net/wiki/spaces/MON/pages/212008946/Create+an+Invoice)
  - [Cancel invoice](https://teamapt.atlassian.net/wiki/spaces/MON/pages/213909772/Cancel+an+Invoice)
  - [Get invoice details](https://teamapt.atlassian.net/wiki/spaces/MON/pages/212008971/View+Invoice+Details)
  - [Initiate refund](https://teamapt.atlassian.net/wiki/spaces/MON/pages/229900080/Initiate+Refund)

## How to use:
- Get started with Monnify by [creating an account](https://app.monnify.com/create-account)
- Get your **API Key**, **Secret Key**, **Base URL** and **CONTRACT CODE** from [devloper section](https://app.monnify.com/developer)
- Create a reserved account to test invoices with from [reserved account section](https://app.monnify.com/reserved-accounts) and keep the account reference (we will use it later).
  - Note: We need to create a reserved account as the current implemented APIs don't handle account creations, but Monnify provide the [API](https://teamapt.atlassian.net/wiki/spaces/MON/pages/212008993/Reserved+Account+Invoicing) for handling that.
- Now we are ready to test our APIs.
- We can track APIs actions from our reserved account page in Monnify's dashboard.

## APIS
- Create invoice payment:
 
    - **URL** : `/payment`

    - **Method** : `POST`

    - **Body** : 
        ```yaml
            {
               "amount": 120.3,
               "customerName": "John",
               "customerEmail": "ada",
               "accountReference": "a17", // the reference of the reserved account we created above
               "description": "Trial transaction"
            } 
- Get Invoice details
   - URL : `/payment/invoice/{invoiceReference}`

   - Method : `GET`

   - Invoice reference is returned from the creation request and also can be found on Monnify's dashboard (PAYMENT REF)
   
- Cancel Invoice
   - URL : `/payment/invoice/{invoiceReference}`

   - Method : `DELETE`

   - Invoice reference is returned from the creation request and also can be found on Monnify's dashboard (PAYMENT REF)
   
- Initiate Refund (to be done)
  - **URL** : `/refund`

   - **Method** : `POST`

   - **Body** : 
        ```yaml
            {
            } 
            
## Build and Run
- Clone the repo.
- Make sure you have JDK 11 installed
- Define your Envirnoment Variables in the IDE configurations:
  - Ex: In IntelliJ IDEA open (Run -> Edit Configurations -> Envirnoment Variables), set your variables as comma separated values as the following:
    ```yaml
    {
      MONNIFY_API_KEY=<API_KEY>;MONNIFY_SECRET_KEY=<SECRET_KEY>;MONNIFY_BASE_URL=<BASE_URL>;MONNIFY_CONTRACT_CODE=<CONTRACT_CODE>
    }
    
 - Build and run the project, by default it runs on port 8080

### OPTIONAL: Run using docker
- In case you prefer using docker so:
- Update envirnoment variables in docker compose file.
- Make sure the project is built and .jar file is generated in target directory.
  ```
  mvn clean install
  ```
- Finally
  ```
  docker-compose build

  docker-compose up
  ```

## To be done:
- Authentecation
- Refund APIs
- Handle Monnify's Web hooks
- Unit tests
- Reserved account creation per user
- Store transactions in a DB from our side
