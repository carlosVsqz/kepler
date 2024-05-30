FROM gradle:8.4-jdk AS build

WORKDIR /workspace/app
COPY . /workspace/app
RUN --mount=type=cache,target=/root/.gradle gradle -Pvaadin.productionMode=true bootJar

FROM openjdk:17-jdk-alpine

ARG DEPENDENCY=/workspace/app/build/libs

COPY --from=build ${DEPENDENCY}/kepler-0.0.1-SNAPSHOT.jar /app/kepler.jar

WORKDIR /app

CMD ["java", "-jar", "kepler.jar"]

EXPOSE 8080/tcp
