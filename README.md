# CloudComputingServer

Technical Introduction:
Proposal type: Option B (develop a web application and deploy the application in the cloud)
Stakeholders: sport playground business owner and customer
Cloud Computing Platform: AWS 
Application Architecture: a Three-Tier application, which has a backend layer, database layer, and client layer.
Decoupling Services:  Restful API design: 
- User: /api/users/login 
- User: /api/users/register
- User: POST /api/orders
- User: GET /api/orders/{id}
- User and Administrator: PUT /api/orders/{id} (status: waiting, done)
- User: DELETE /api/orders/{id}
- Administrator: POST /api/courts (include upload files )
- Administrator: GET /api/courts/{id}
- Administrator: PUT /api/courts/{id}  (include upload files )
- Administrator: DELETE /api/courts/{id}

Security: Spring Security and JWT
Host: cloudcomputingserver-env-1.eba-kts3pt8t.us-east-1.elasticbeanstalk.com

API document: Swagger, document URL for loalhost: http://localhost:8082/swagger-ui/index.html

Deployment on the cloud: deploy client side and back end (Restful API) on  AWS Lambda.

Cloud Database: We will choose NoSQL databases DynamoDB

Storage: web application assets such as pictures, files, etc., will be stored on cloud storage services such as AWS S3.

Languages/Framework:  Java for Backend Service, and JS/ React/Vue to develop web applications.

Code on GitHub:  https://github.com/AUTCloudComputing/CloudComputingServer 

Code on GitHub:  https://github.com/AUTCloudComputing/CloudComputingWebApp 

 
