# Spring Boot 3 - Prometheus + Grafana

This is a demo project of spring boot 3 integration of Prometheus and Grafana

## Architecture

Client Service --> Server Service

## Tech Stack

+ Spring Boot 3
+ RestTemplate
+ Spring Actuator
+ Prometheus
+ Grafana


## How to setup

Run docker container of following command
```shell
docker-compose up
```

Clone the repository and install dependencies
```shell
mvn clean install
```

Hit client API

```shell
curl --location 'http://localhost:8080/client/34'
```

Then login to `http://localhost:3000` with `admin/admin` for grafana.
For prometheus, visit `http://localhost:9090`

These 2 places will provide monitoring info for applications. 

