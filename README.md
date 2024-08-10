
# Backend engine for an investment management platform

This backend engine is the core component of an investment management platform, designed to handle user management, portfolio management, market data, executing transactions on real-time data, and notifications in a highly scalable and secure microservices architecture.


## Tech-stacks
Architecture: Microservice   
Tech: Java Springboot    
Authentication: Keycloak    
API Gateway: Spring cloud gateway    
Interservice communication: retrofit    
Database: Postgres SQL  
Messaging/Notifications: RabbitMQ  
## Service Discovery  
Service discovery is a critical component of the microservices architecture. In this platform, Spring Cloud Eureka is used as the service registry and discovery service. Eureka enables each microservice to register itself with the Eureka server, allowing other services to discover and communicate with it dynamically. This approach eliminates the need for hardcoded IP addresses and ensures seamless interaction between microservices, even as they scale or change.
## Microservices Link
[user-service](https://github.com/Renish-2811/investment-management-user-service)  
[portfolio-service](https://github.com/Renish-2811/investment-management-portfolio-service)      
[service-discovery](https://github.com/Renish-2811/investment-management-service-discovery)    
## DB Architecture
User Service  
Handles user details, authentication, authorization, user verification, login/logout, PAN verification,KYC verification and the user onboarding journey.

Portfolio Service  
Manages user portfolios, including adding and fetching portfolio details, performing portfolio analysis, managing various investments such as stocks and commodities, and enhanced capabilites such as performing transactions on live data that is fetched from websocket.  
[DB-Link](https://drawsql.app/teams/backend-engine-for-investment-management-platform/diagrams/db)  

<img src="https://github.com/user-attachments/assets/1e4e477d-0b47-43e8-bca0-e1b305ad8555" alt="drawSQL-image-export-2024-08-10" width="500"/>

## API Documentation
[Postman Link for API Documentation](https://documenter.getpostman.com/view/26321132/2sA3s3HWZ3)
