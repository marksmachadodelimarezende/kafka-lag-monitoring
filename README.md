# Projetct: stack-cases
Repository with docker compose stack cases

## Docker images
* **zookeeper**: wurstmeister/zookeeper
* **kafka**: wurstmeister/kafka
* **kafdrop**: obsidiandynamics/kafdrop

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
docker-compose down
````
 
## Validations
After docker-compose up services:
* Check Kafdrop service: [locahost:9000](http://localhost:9000/)
