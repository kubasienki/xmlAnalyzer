FROM openjdk:8
ADD target/xmlanalyzer-0.0.1-SNAPSHOT.jar xmlanalyzer-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "xmlanalyzer-0.0.1-SNAPSHOT.jar", "-Xmx512m"]