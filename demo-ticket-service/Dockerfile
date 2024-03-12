FROM openjdk:17-jdk-slim
COPY demo-ticket-service-0.0.1-SNAPSHOT.jar demo-ticket-service.jar
# ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .
COPY opentelemetry-javaagent.jar opentelemetry-javaagent.jar
ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"
ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://otel-collector:4318 
# 数据报告给collector，collector位于otel-collector:4318 
ENV OTEL_TRACES_SAMPLER_ARG=1
# 采样率（未知是否有效）
EXPOSE 8082
ENTRYPOINT [ "java", "-jar", "/demo-ticket-service.jar"]
