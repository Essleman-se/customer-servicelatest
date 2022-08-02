FROM openjdk:8
EXPOSE 8080
ADD target/cust_serv_maven.jar cust_serv_maven.jar
ENTRYPOINT ["java","-jar","/cust_serv_maven.jar"]