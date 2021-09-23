#FROM java:14
#
## Add Author info
#LABEL maintainer="Bryce"
#
## Add a volume to /tmp
#VOLUME /tmp
#
## Make port 8080 available to the world outside this container
#EXPOSE 8080
#
## The application's jar file
#ARG JAR_FILE=build/libs/MySpringApp-0.0.1-SNAPSHOT.jar
#
## Add the application's jar to the container
#ADD ${JAR_FILE} to-do-springboot.jar
#
## Run the jar file
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/to-do-springboot.jar"]

FROM openjdk:8-jdk
# 어떤 이미지로부터 새로운 이미지를 생성할 지 지정. 플랫폼 : 버전 형태로 작성

MAINTAINER bryce <nash31@korea.ac.kr>
# Dockerfile을 생성-관리하는 사람

VOLUME /tmp
# 호스트의 directory를 docker 컨테이너에 연결. 즉 소스코드나 외부 설정파일을 커밋하지 않고 docker container에서 사용가능하도록 함

ARG JAR_FILE=build/libs/produce300-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} produce300.jar
ENTRYPOINT ["java", "-jar", "/produce300.jar"]



# ./gradlew build 후 Dockerfile을 설정한다.
#  docker build -t nash31/produuce300 .
# docker run -d --name produce300 -p 8080:8080 nash31/produce300