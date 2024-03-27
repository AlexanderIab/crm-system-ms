FROM openjdk

EXPOSE 8888

ADD build/libs/config-server-1.1.0.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]