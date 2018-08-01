# Running the project
```bash
# install docker, docker-compose and httpie up front
# navigate to backend-engineer folder
docker-compose up #starts PostgreSQL
mvn package #builds the service
java -jar target/categories-demo-0.0.1-SNAPSHOT.jar & #starts the service
# Below is the link for swagger
http://localhost:8080/swagger-ui.html#/category-controller
```

