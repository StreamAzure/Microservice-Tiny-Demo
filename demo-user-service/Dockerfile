FROM openjdk:17-jdk-slim
COPY demo-user-service-0.0.1-SNAPSHOT.jar demo-user-service.jar
# ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .
COPY opentelemetry-javaagent.jar opentelemetry-javaagent.jar
ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"
ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://jaeger-service:4318
# 采集数据直接导出给Jaeger，不经过 OpenTelemetry collector
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/demo-user-service.jar" ]
