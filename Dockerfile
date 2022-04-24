FROM openjdk:11

COPY ./minutes /minutes

WORKDIR /minutes

CMD ["./gradlew", "bootRun"]
