# 基于 Spring Boot 的微服务远程调用极简 Demo
## 环境
JDK 17 + Spring Boot 3.2.3
## Demo 服务架构
- user-service (Java Spring Boot): 数据库查询，返回用户信息
- ticket-service (Java Spring Boot)：远程调用 user-service 查询用户信息，再返回车票信息
- station-service (Python Flask)：数据库查询，返回车站信息
## Demo 部署
1. 自行将 `demo-` 开头的各个模块编译打包成 jar 包，注意路径及名称：
    ```
    demo-ticket-service/target/demo-ticket-service-0.0.1-SNAPSHOT.jar
    demo-user-service/target/demo-user-service-0.0.1-SNAPSHOT.jar
    ```
2. 通过 docker-compose 部署：
    ```shell
    docker-compose up -d
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
    - station-service
        ```shell
        curl http://localhost:5000/
        curl http://localhost:5000/station/1
        ```