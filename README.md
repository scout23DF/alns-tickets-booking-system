# ALNS-Tickets-Booking-System

## Prerequisites

### Java

You need to have Java 21:

- [JDK 21](https://openjdk.java.net/projects/jdk/21/)

### Node.js and NPM

Before you can build this project, you must install and configure the following dependencies on your machine:

[Node.js](https://nodejs.org/): We use Node to run a development web server and build the project.
Depending on your system, you can install Node either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

```
npm install
```

## Local environment

- [Local server](http://localhost:8060)
- [Local API doc](http://localhost:8060/swagger-ui.html)

<!-- jhipster-needle-localEnvironment -->

## Start up

```bash
./mvnw
```

```bash
docker compose -f src/main/docker/postgresql.yml up -d
```

```bash
docker compose -f src/main/docker/consul.yml up -d
```

```bash
docker compose -f src/main/docker/keycloak.yml up -d
```

<!-- jhipster-needle-startupCommand -->

## Documentation

- [Package types](documentation/package-types.md)
- [Assertions](documentation/assertions.md)
- [PostgreSQL](documentation/postgresql.md)
- [LangChain4j](documentation/langchain4j.md)
- [Logs Spy](documentation/logs-spy.md)
- [Dev tools](documentation/dev-tools.md)
- [CORS configuration](documentation/cors-configuration.md)
- [Jpa pages](documentation/jpa-pages.md)
- [Cucumber](documentation/cucumber.md)
- [Kipe authorization](documentation/kipe-authorization.md)
- [Kipe expression](documentation/kipe-expression.md)
- [Rest pagination](documentation/rest-pagination.md)
- [Cucumber authentication](documentation/cucumber-authentication.md)
- [Sample](documentation/sample.md)

<!-- jhipster-needle-documentation -->
