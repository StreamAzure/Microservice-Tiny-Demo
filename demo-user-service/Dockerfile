FROM openjdk:17-jdk-slim
COPY target/demo-user-service-0.0.1-SNAPSHOT.jar demo-user-service.jar
COPY http-proxy-agent-1.3.5-dist.jar http-proxy-agent-1.3.5-dist.jar 
COPY ca.pem ca.pem

ENV JAVA_TOOL_OPTIONS "-javaagent:/http-proxy-agent-1.3.5-dist.jar='interceptor|8080|./ca.pem'"

EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/demo-user-service.jar" ]