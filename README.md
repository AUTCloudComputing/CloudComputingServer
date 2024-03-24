# CloudComputingServer

Technical Introduction:
Proposal type: Option B (develop a web application and deploy the application in the cloud)
Stakeholders: sport playground business owner and customer
Cloud Computing Platform: AWS 
Application Architecture: a Three-Tier application, which has a backend layer, database layer, and client layer.
Decoupling Services:  Restful API design: 
- User: /login 
- User: /register
- User: POST /orders
- User: GET /orders/{id}
- User and Administrator: PUT /orders/{id} (status: waiting, done)
- User: DELETE /orders/{id}
- Administrator: POST /playgrounds (include upload files )
- Administrator: GET /playgrounds/{id}
- Administrator: PUT /playgrounds/{id}  (include upload files )
- Administrator: DELETE /playgrounds/{id}
Deployment on the cloud: deploy client side and back end (Restful API) on  AWS AWS Elastic Beanstalk.
Cloud Database and Storage: We will choose SQL databases such as AWS RDS, and web application assets such as pictures, files, etc., will be stored on cloud storage services such as AWS S3.
Languages/Framework:  Java for Backend Service, and JS/ React/Vue to develop web applications.
Code on GitHub:  https://github.com/AUTCloudComputing/CloudComputingServer 
Code on GitHub:  https://github.com/AUTCloudComputing/CloudComputingWebApp 

