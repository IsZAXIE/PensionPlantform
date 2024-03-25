FROM openjdk:17

LABEL authors="zaxie"

COPY *.jar /app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app.jar"]
