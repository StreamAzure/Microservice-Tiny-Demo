FROM openjdk:17-jdk-slim
COPY target/demo-user-service-0.0.1-SNAPSHOT.jar demo-user-service.jar

COPY ../apache-skywalking-java-agent-9.1.0.tgz apache-skywalking-java-agent-9.1.0.tgz
RUN tar -xzf apache-skywalking-java-agent-9.1.0.tgz

# 捕获的数据库语句显示具体参数
ENV SW_JDBC_TRACE_SQL_PARAMETERS=true
ENV JAVA_TOOL_OPTIONS "-javaagent:./skywalking-agent/skywalking-agent.jar -Dskywalking.agent.service_name=user-service -Dskywalking.collector.backend_service=oap-server:11800"

EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/demo-user-service.jar" ]