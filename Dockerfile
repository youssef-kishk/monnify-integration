FROM openjdk:11
ADD target/monnify-integration-docker.jar monnify-integration-docker.jar
ENTRYPOINT ["java","-jar","/monnify-integration-docker.jar"]