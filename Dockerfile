FROM java:8

MAINTAINER szczygielski

RUN mkdir -p /simple-sample/app
ENV PROJECT_HOME /simple-sample/app

ARG JAR_FILE
ADD ${JAR_FILE} $PROJECT_HOME/simple-sample.jar

COPY /target/classes/names.txt $PROJECT_HOME/names.txt

WORKDIR $PROJECT_HOME

ENTRYPOINT ["java", "-jar", "-Dspring.data.mongodb.uri=mongodb://mongodb:27017/simple-sample", "-DSpring.profiles.active=dev,docker,data-init", "simple-sample.jar"]
