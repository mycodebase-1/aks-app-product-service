FROM maven:3.6.3-jdk-8-slim AS build
WORKDIR /home/product-service
COPY . /home/product-service
RUN mvn -f /home/product-service/pom.xml clean package -DskipTests

FROM java:8-jdk-alpine
VOLUME /tmp
COPY --from=build /home/product-service/target/*.jar product-service.jar
ENTRYPOINT ["java","-jar","product-service.jar"]
