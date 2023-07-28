FROM tomcat:10.1.11-jdk21-openjdk-slim
COPY target/*war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
