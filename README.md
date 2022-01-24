# Spring Boot ecommerce app  using Docker Compose

1.generate jar file ->  mvn clean package

2.remove docker image if exist -> docker container rmi adnanebk/springboot-ecommerce

2.creating docker image by using Docker Compose (docker-compose.yml)  ->  docker-compose build

starting the container (application)  ->  docker-compose up


removing docker container  ->  docker-compose down


pushing image to docker hub :
1. docker login  ( username : adnanebk / password : springboot )
2. docker push adnanebk/springboot-ecommerce:latest

pulling image from docker hub and run it :
docker run --rm -d -p 8080:8080 adnanebk/springboot-ecommerce:latest