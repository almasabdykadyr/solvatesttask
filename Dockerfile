FROM gradle as bulder
WORKDIR /opt/app
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY /src /src
RUN ./gradlew clean build

FROM eclipse-temurin:21
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
