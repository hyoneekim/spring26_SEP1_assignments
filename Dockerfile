FROM maven:3.9.12
LABEL authors="suhyunkim"

WORKDIR /app

COPY pom.xml .

COPY . /app

RUN mvn package

CMD ["java", "-jar", "target/opt1.jar"]