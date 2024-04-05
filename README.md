# 基于 Spring Boot 的微服务远程调用极简 Demo
## 环境
JDK 17 + Spring Boot 3.2.3
## Demo 调用关系示意图
![调用关系示意图](assets/demo-relation.png)
## Demo 部署
### 通过 Docker-compose
1. 自行将 `demo-` 开头的各个模块编译打包成 jar 包，注意路径及名称：
    ```shell
    demo-ticket-service/target/demo-ticket-service-0.0.1-SNAPSHOT.jar
    demo-user-service/target/demo-user-service-0.0.1-SNAPSHOT.jar
    ```
2. 通过 docker-compose 部署：
    ```shell
    docker-compose up --build -d
    # 停止并删除容器：docker-compose down
    ```
3. 测试
    - OpenFeign 调用
        ```shell
        curl http://localhost:8082/buyTicket/feign/1
        # User(id=1, name=张三), station 上海
        ```
    - RestTemplate 调用
        ```shell
        curl http://localhost:8082/buyTicket/restful/1
        # User(id=1, name=张三), station 北京
        ```
   
   URL末尾数字为1或2时，查询的是MySQL中的数据；为3或4时，查询的是服务内部直接初始化的模拟数据
### 通过 k8s（Kind）
1. 自行将 `demo-` 开头的各个模块编译打包成 jar 包
   ```shell
   demo-ticket-service/demo-ticket-service-0.0.1-SNAPSHOT.jar
   demo-user-service/demo-user-service-0.0.1-SNAPSHOT.jar
   ```
   然后打包镜像：
   ```shell
   docker build ./demo-ticket-service -t demo/user-service:base
   docker build ./demo-user-service -t demo/ticket-service:base
   ```
2. 通过 kind 启动 k8s 集群
   ```shell
   kind create cluster
   ```
3. 将镜像加载到 kind 内部
   ```shell
   kind load docker-image demo/ticket-service:base demo/user-service:base mysql:8.0.33
   ```
   注意：deployment-base.yml 中 imagePullPolicy 已设置为 Never，镜像必须加载到 kind 内部才会正常启动，否则直接启动失败，且不会从任何地方拉取镜像
4. 部署并将端口转发出来（因为集群跑在kind容器中，在容器外部通过NodeIP:NodePort不能访问Ticket服务，除非进入容器内部执行）
   ```shell
   kubectl apply -f deployment-base.yml
   kubectl apply -f service.yml
   
   # 端口转发
   kubectl port-forward svc/ticket-service 32756:8082
   ```
5. 访问 Ticket 服务
   ```shell
   curl http://localhost:32756/buyTicket/restful/3
   # 或
   curl http://localhost:32756/buyTicket/feign/4
   ```
   注意末尾的数字只能是3或4，这访问的是服务内部直接初始化的模拟数据；1或2则会查询MySQL；MySQL中的数据自动初始化尚未完成，目前部署方案下MySQL中初始无数据

## OpenTelemetry + Jaeger 链路追踪组件部署
见 [jaeger 分支](https://github.com/StreamAzure/Microservice-Tiny-Demo/tree/jaeger)