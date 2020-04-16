FROM centos

RUN yum install -y java

VOLUME /tmp
ADD /starwars-boot.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]
ENV JAVA_HOME /etc/alternatives/jre
