FROM openjdk:8
ADD target/store.jar store.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "store.jar"]