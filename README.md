# Spring-Boot-Data example with Vaadin-Spring-Boot and multi gradle build

An example project for to evaluate an test the following technology stack:

* [JPA Modeller](http://jpamodeler.github.io/) for modelling the persistance layer
* [Gradle](https://gradle.org/) as the build system, with the [Spring Boot Gradle plugin](http://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-gradle-plugin.html)
* [Vaadin](https://vaadin.com/home) for the presentation layer
* [Spring-Boot-Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters) for the enterprise backend

The application is separated in sub-projects for the domain-model, the service layer, the user interface and the application 
itself.

Only run

```java
gradle bootRun
```

and access [localhost:8080](http://localhost:8080/).