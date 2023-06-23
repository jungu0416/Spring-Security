FROM adoptopenjdk/openjdk8:ubi AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk/openjdk8:ubi
COPY --from=builder build/libs/*.jar app.jar

EXPOSE 8084
ENTRYPOINT ["java","-jar","/app.jar"]