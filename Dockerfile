FROM openjdk:14-jdk-alpine
MAINTAINER Özay DUMAN <ozay.duman@gmail.com>
RUN mkdir -p /var/log/ecs-sample-service
RUN addgroup -S spring && adduser -S spring -G spring
RUN chown spring /var/log/ecs-sample-service
USER spring:spring
ADD target/ecs-logging-0.0.1-SNAPSHOT.jar ecs-logging.jar
ENTRYPOINT ["java","-jar","/ecs-logging.jar"]
