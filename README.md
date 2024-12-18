# Projetct: stack-cases
Repository with docker compose stack cases

## Docker images
* **zookeeper**: wurstmeister/zookeeper
* **kafka**: wurstmeister/kafka
* **kafdrop**: obsidiandynamics/kafdrop
* **burrow**: golang:1.22.3-alpine build
* **burrow-exporter**: simenduev/burrow-exporter
* **otel-lgtm**: grafana/otel-lgtm:0.6.0 (Prometheus included)

## Running
Create docker network if necessary before execute docker-compose up.
```shell
docker network create "observability-network"
```

Execute docker-compose
```shell
docker-compose up -d
```

Stopping docker-compose
````shell
docker-compose stop
````
 
## Validations
After docker-compose up services:
* Check Kafdrop service: [locahost:9000](http://localhost:9000/)
* Check Prometheus service: [locahost:9090](http://localhost:9090/)
* Check Grafana service: [locahost:3000](http://localhost:3000/)

### Using docker:
Monitoring docker images instances
````shell
docker ps
````

Monitoring docker resources usage
````shell
docker stats
````
