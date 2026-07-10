#Star with base image container java runtime
FROM eclipse-temurin:21-jdk AS build

#information of owner or maintainer of image
LABEL maintainer="pisethbank"

#add the application's jar to the container
COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java","-jar","/eurekaserver-0.0.1-SNAPSHOT.jar"]
