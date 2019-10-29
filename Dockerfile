FROM alpine:edge
USER root

RUN apk update && \
    apk fetch openjdk8 && \
    apk add openjdk8

ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk 
ENV PATH="$JAVA_HOME/bin:${PATH}"    

COPY ./files /files
WORKDIR /files
RUN javac -cp "minio-6.0.11-all.jar"  FileUploader.java
RUN java -cp "minio-6.0.11-all.jar:." FileUploader