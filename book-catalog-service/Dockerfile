FROM openjdk

#COPY c:/Users/Fernando/.m2/repositosy /root/.m2/repository

WORKDIR /app

COPY target/book-catalog-service-0.0.1-SNAPSHOT.jar /app/catalog-service-2.jar

ENTRYPOINT [ "java", "-jar", "catalog-service-2.jar" ]