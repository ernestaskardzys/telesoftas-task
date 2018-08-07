## Running the project

In order to run the project, execute the following commands:

```bash
$ ./gradlew clean build
$ docker-compose build
$ docker-compose up
```

To test running container please run:

```bash
$ curl localhost/list
$ curl localhost/test/data
$ curl localhost/list
```

First command should return existing data in the database (none). Second one - adds some mock data into the database.

Third command just returns Inserted data from the database.

*test/data* is handled by *TestController* - mock class to help debugging the application.

## MongoDB

To see the database of MongoDB - please open http://localhost:8081/

## Tested on

All tests have been run on the following environment:

- Ubuntu Linux 18.04 (4.15.0-29-generic)
- Java 1.8.0_181-b13
- Docker 17.12.1-ce
- Docker Compose 1.17.1
