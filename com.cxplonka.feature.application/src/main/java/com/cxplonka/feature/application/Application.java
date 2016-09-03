/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cxplonka.feature.application;

import com.cxplonka.feature.domain.Customer;
import com.cxplonka.feature.service.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author cplonka
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.cxplonka.**")
@EntityScan(basePackages = "com.cxplonka.**")
@EnableJpaRepositories("com.cxplonka.**")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Nick", "Nolte"));
            repository.save(new Customer("Chuck", "Norris"));
            repository.save(new Customer("Christian", "Plonka"));
            repository.save(new Customer("Bam", "Bi"));
            repository.save(new Customer("Michelle", "Dessler"));
            repository.save(new Customer("Christian", "Dessler"));
            repository.save(new Customer("Sarah", "Dessler"));
            repository.save(new Customer("Marian", "Dessler"));
            repository.save(new Customer("Alfred", "Dessler"));
            repository.save(new Customer("Elfriede", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");
        };
    }
}
