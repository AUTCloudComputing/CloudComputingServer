# CloudComputingServer
![Blue Modern Badminton Tournament Facebook Cover](booking-system-maven/web_app/src/main/webapp/img/logingBg.gif)


Access to Web Client Link: https://chenyilong.com/pages/login.html

----------------
 
Admin role username: elon2_admin
Admin role password: password123
 
---------------
 
User role username: customer
User role password: password123
 
---------------
 
User role username: customer02
User role password: password123



This is the API documents:
 
http://54.89.63.70:5000/swagger-ui/index.html
 
and at the end of the report , we also give a list of API.


## User's manual

![Screen Shot 2024-05-18 at 19.08.45](assets/Screen%20Shot%202024-05-18%20at%2019.08.45.png)

![Screen Shot 2024-05-18 at 19.09.17](assets/Screen%20Shot%202024-05-18%20at%2019.09.17.png)


![Screen Shot 2024-05-18 at 19.09.22](assets/Screen%20Shot%202024-05-18%20at%2019.09.22.png)


![Screen Shot 2024-05-18 at 19.09.34](assets/Screen%20Shot%202024-05-18%20at%2019.09.34.png)

![Screen Shot 2024-05-18 at 19.09.36](assets/Screen%20Shot%202024-05-18%20at%2019.09.36.png)
![Screen Shot 2024-05-18 at 19.11.16](assets/Screen%20Shot%202024-05-18%20at%2019.11.16.png)
![Screen Shot 2024-05-18 at 19.11.20](assets/Screen%20Shot%202024-05-18%20at%2019.11.20.png)
![Screen Shot 2024-05-18 at 19.11.26](assets/Screen%20Shot%202024-05-18%20at%2019.11.26.png)
![Screen Shot 2024-05-18 at 19.11.51](assets/Screen%20Shot%202024-05-18%20at%2019.11.51.png)
![Screen Shot 2024-05-18 at 19.12.01](assets/Screen%20Shot%202024-05-18%20at%2019.12.01.png)
![Screen Shot 2024-05-18 at 19.12.14](assets/Screen%20Shot%202024-05-18%20at%2019.12.14.png)
![Screen Shot 2024-05-18 at 19.12.22](assets/Screen%20Shot%202024-05-18%20at%2019.12.22.png)
![Screen Shot 2024-05-18 at 19.12.27](assets/Screen%20Shot%202024-05-18%20at%2019.12.27.png)
![Screen Shot 2024-05-18 at 19.12.33](assets/Screen%20Shot%202024-05-18%20at%2019.12.33.png)
![Screen Shot 2024-05-18 at 19.12.54](assets/Screen%20Shot%202024-05-18%20at%2019.12.54.png)

![Screen Shot 2024-05-18 at 19.13.01](assets/Screen%20Shot%202024-05-18%20at%2019.13.01.png)
![Screen Shot 2024-05-18 at 19.13.06](assets/Screen%20Shot%202024-05-18%20at%2019.13.06.png)
![Screen Shot 2024-05-18 at 19.13.12](assets/Screen%20Shot%202024-05-18%20at%2019.13.12.png)
![Screen Shot 2024-05-18 at 19.13.20](assets/Screen%20Shot%202024-05-18%20at%2019.13.20.png)
![Screen Shot 2024-05-18 at 19.13.26](assets/Screen%20Shot%202024-05-18%20at%2019.13.26.png)
![Screen Shot 2024-05-18 at 19.13.32](assets/Screen%20Shot%202024-05-18%20at%2019.13.32.png)


## Technical Introduction:
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

Host Mapping in development environment: 





host | mock host | description
-|-|-
127.0.0.1|              chenyilong.com | mock host

API document: Swagger, document URL for localhost:  


This is the API documents:
 
http://54.89.63.70:5000/swagger-ui/index.html
 
 


Deployment on the cloud: deploy client side and back end (Restful API) on  AWS Lambda.

Cloud Database: We will choose NoSQL databases DynamoDB

Storage: web application assets such as pictures, files, etc., will be stored on cloud storage services such as AWS S3.

Languages/Framework:  Java for Backend Service, and JS/ React/Vue to develop web applications.

Code on GitHub:  https://github.com/AUTCloudComputing/CloudComputingServer 

 
 
## nginx config

![](assets/nginx_map.jpg)


mock host | description
-|-
chenyilong.com/api/ | backend/server host
chenyilong.com/ | frontend/web host


Nginx Config: 

start nginx

 ```shell
sudo yum install nginx
nginx
 ```



reload nginx


 ```shell
sudo nginx -s stop && sudo nginx

 ```


 ```Java
# Load dynamic module configurations
include /usr/local/etc/nginx/modules/*.conf;

events {
    worker_connections 1024;
}

http {
    include mime.types;
    default_type application/octet-stream;
    sendfile on;
    keepalive_timeout 65;

    # Universal server for handling both backend API and front-end
    server {
        listen 80;
        server_name chenyilong.com;

        # Location block for API
        location /api/ {
            # CORS headers
            add_header 'Access-Control-Allow-Origin' '*';
            add_header 'Access-Control-Allow-Methods' 'GET, POST, OPTIONS';
            add_header 'Access-Control-Allow-Headers' 'DNT,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Range,Authorization';
            add_header 'Content-Type' 'text/plain; charset=utf-8';

            # Set headers for proxying
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header Host $http_host;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;

            # Proxy pass to backend API
            proxy_pass http://127.0.0.1:5000;  # API server
        }

        # Location block for front-end
        location / {
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header Host $http_host;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;

            # Proxy pass to front-end
            proxy_pass http://127.0.0.1:8082;  # front-end server 
        }
    }
}

 ```

- using-secrets-in-github-actions to save secrets key instead of git ignore. (Reference: https://docs.github.com/en/actions/security-guides/using-secrets-in-github-actions ) 
