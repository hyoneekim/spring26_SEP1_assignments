FROM maven:3.9.12
LABEL authors="suhyunkim"

WORKDIR /app

COPY pom.xml .

COPY . /app

RUN mvn package

CMD ["java", "-jar", "target/OTP1_inclass_assignment-1.0-SNAPSHOT.jar"]