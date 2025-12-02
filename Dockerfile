# I have it set up to match the version of Java used in the project. Mine is using Eclipse Temurin 24.


FROM eclipse-temurin:24
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]