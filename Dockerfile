FROM openjdk:17

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN .mvnw -B package

FROM openjdk:20

ADD ./target/KanbanDesk-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]