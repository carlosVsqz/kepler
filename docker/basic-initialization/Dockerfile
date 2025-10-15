FROM gradle:8.4-jdk AS build

WORKDIR /workspace/app
COPY . /workspace/app
RUN --mount=type=cache,target=/root/.gradle gradle -Pvaadin.productionMode=true bootJar

FROM openjdk:17-jdk-slim

ARG DEPENDENCY=/workspace/app/build/libs

COPY --from=build ${DEPENDENCY}/kepler-0.0.1-SNAPSHOT.jar /app/kepler.jar

WORKDIR /app

ENV JAVA_OPTS="\
                -XX:+UseContainerSupport \
                -XX:MaxRAMPercentage=75 \
                -XX:InitialRAMPercentage=40 \
                -XX:+UseG1GC \
                -XX:ParallelGCThreads=1 \
                -XX:ConcGCThreads=1 \
                -XX:CICompilerCount=1 \
                -XX:ActiveProcessorCount=1 \
              "

#CMD ["java", "-jar", "kepler.jar"]
CMD ["sh", "-c", "java $JAVA_OPTS -jar kepler.jar"]

EXPOSE 8080/tcp
