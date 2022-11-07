FROM amazoncorretto:17-alpine

ENV USERNAME ${USERNAME}
ENV PASSWORD ${PASSWORD}

WORKDIR /project

COPY ./build/libs/spring-webflux-kotlin-0.0.1-SNAPSHOT.jar /project

EXPOSE 8082

CMD java -jar spring-webflux-kotlin-0.0.1-SNAPSHOT.jar "--spring.data.mongodb.uri=mongodb://${USERNAME}:${PASSWORD}@mongodb:27017" "--spring.data.mongodb.database=mflix"


