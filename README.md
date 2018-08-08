## Technologies used

I have used the following technologies:
* [Spring Boot](http://spring.io/projects/spring-boot)
* [Docker](https://www.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/)
* [Nginx](https://www.nginx.com/)
* [Gradle](https://gradle.org/)
* [ActiveMQ](http://activemq.apache.org/)
* [MongoDB](https://www.mongodb.com/)

## Refactoring process

I applied the following process:

- Cover high-level tests existing code. By using existing test fixture class I've generated output for 1st, 2nd and 99th day. And used that data for tests.
- Try to make some initial small refactorings by extracting code.
- Later just started refactoring & developing the whole application by using TDD. 

## Architecture and some comments

As this project is quite small so architecture is a bit artificial. Load balancer is not needed, but I've added it just for fun.

As I prefer to split application into layers, I had to create a couple of objects which are effectively identical: *Item*, *ItemEntity* and *ItemResponse*.

- *Item* is original class.
- *ItemEntity* is an entity class for database.
- *ItemResponse* is a POJO class used return response to the client.

We could technically use one object for all the tasks above, but I strongly believe that layers of application should be separated. Hence three objects were born.

*GildedRoseTest* is used as integration test for the main part of the system - calculation.

Nginx is used as load balancer. We have two instances of microservices running, so we need to load balance requests. At the same time, Nginx works as a proxy - it redirects requests from port 80 to 8080 of the microservices.

### Scheduler

Scheduler runs once per day - at 9 AM.

## Running the project

In order to run the project, execute the following commands:

```bash
$ ./gradlew clean build
$ docker-compose build
$ docker-compose up --scale gildedrose-service=2
```

To test running container please run:

```bash
$ curl localhost/list
$ curl localhost/test/data
$ curl localhost/test/scheduler
```

First command should return existing data in the database (none). Second one - adds some mock data into the database.

Third command manually executes scheduler - if we don't want to wait until tomorrow's 9 AM.

*test/data* is handled by *TestController* - mock class to help debugging the application.

## MongoDB

To see the database of MongoDB - please open [MongoDB](http://localhost:8081/)

## Tested on

All tests have been run on the following environment:

- Ubuntu Linux 18.04 (4.15.0-29-generic)
- Java 1.8.0_181-b13
- Docker 17.12.1-ce
- Docker Compose 1.17.1
