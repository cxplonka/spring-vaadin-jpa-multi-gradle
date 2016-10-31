# Spring-Boot-Data example with Vaadin-Spring-Boot and multi gradle build

An example project to evaluate an test the following technology stack:

* [JPA Modeller](http://jpamodeler.github.io/) for modelling the persistance layer.
* [Gradle](https://gradle.org/) as the build system, with the [Spring Boot Gradle plugin](http://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-gradle-plugin.html).
* [Vaadin](https://vaadin.com/home) for the presentation layer.
* [Spring-Boot-Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters) for the enterprise backend.
* [Apache Camel](http://camel.apache.org/) for Enterprise Integration Patterns.
* [hawtio](http://hawt.io/) as modular web console, for discover metrics, camel routes etc.
* [jailer](https://github.com/Wisser/Jailer) an tool for database subsetting, schema and data browsing. Perfect for create consistent DB test data.
* [Docker](https://www.docker.com/) for a new level of application deployment, management and orchestration.

The application is separated in sub-projects for the domain-model, the service layer, the user interface and the application 
itself.

Only run (will use an H2 in memory database):

```java
gradle bootRun
```

You can also run this example inside Docker with an Postgres Database:

```java
// assemble for fat jar
gradle assemble

// build images (pull, build)
docker-compose build

// start database and spring-boot project
docker-compose up -d

```

it will use the [spring-profile = docker-postgres].

and access: 
 * Vaadin UI - [localhost:8080](http://localhost:8080/)
 * Hawtio Web-Console - [localhost:8080/hawtio](http://localhost:32768/hawtio/index.html)