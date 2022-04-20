FROM openjdk:8-jre
MAINTAINER pdai
WORKDIR /
ADD target/springboot-demo-helloworld.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar"]
CMD ["app.jar"]