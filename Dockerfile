FROM java:8

RUN mkdir /app
WORKDIR /app
COPY target/xa.jar /app
EXPOSE 9800

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=docker","-jar", "/app/xa.jar"]