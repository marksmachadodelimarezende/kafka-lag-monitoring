# Detalhes do projeto

### Projeto focado em estudo com intuíto de praticar:
* API rest (Controller)
* Client de app externa com uso de Failsafe para 
retentativas em caso de erros da api consumida
* Uso de produtor e consumidor com Spring Kafka
* Implementação de observabilidade com OpenTelemetry

### Docker-Compose no projeto
##### Observar pasta ```docker``` na raiz do projeto.
* [Kafka with Zookeeper](https://hub.docker.com/r/bitnami/kafka)
* [Kafka kafdrop](https://hub.docker.com/r/obsidiandynamics/kafdrop)
* [OpenTelemetry - Java](https://opentelemetry.io/docs/languages/java/)

### Documentação auxiliar de referência das implementações
#### Produzindo mensagem ao Kafka:
* [Sending a Message](https://docs.spring.io/spring-boot/docs/current/reference/html/messaging.html#messaging.kafka.sending)
#### Consumindo mensgam do Kafka:
* [Receiving a Message](https://docs.spring.io/spring-boot/docs/current/reference/html/messaging.html#messaging.kafka.receiving)
#### Acessando Kafka KafDrop para visualizar os tópicos e mensagens
* [Kafka KafDrop](http://localhost:9000)
#### Configurando instrumentação com OpenTelemetry
* [Open Telemetry](https://opentelemetry.io/docs/languages/java/)

Deve-se exportar as seguintes variáveis de ambiente:
* Na IDE Intellij pode-se configurar como VM Options no runner da app
````
-javaagent:C:\dev\estudos\observability\observability\lib\openTelemetry\agent\opentelemetry-javaagent-2.4.0.jar"
-Dotel.exporter.otlp.protocol=grpc
-Dotel.exporter.otlp.endpoint=http://localhost:4317
-Dotel.service.name=observability-student
-Dotel.javaagent.debug=false
-Dotel.traces.exporter=logging
-Dotel.metrics.exporter=logging
-Dotel.logs.exporter=logging
-Dotel.metric.export.interval=15000
````