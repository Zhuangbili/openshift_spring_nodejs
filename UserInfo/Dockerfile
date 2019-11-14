FROM openjdk:jdk-alpine
VOLUME /tmp
RUN mkdir /app
WORKDIR /app
COPY ./target/*.jar ./
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=openshift -jar ./UserInfo-0.0.1-SNAPSHOT-exec.jar" ]
