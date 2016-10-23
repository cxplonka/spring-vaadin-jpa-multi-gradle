/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cxplonka.feature.service.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author cplonka
 */
@Component
public class SimpleCamelRoute extends RouteBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleCamelRoute.class);

    @Override
    public void configure() throws Exception {
        from("timer://mytimer?period=20000")
                .process(new Processor() {
                    public void process(Exchange msg) {
                        LOG.info("Processing {}", msg);
                    }
                });
    }
}
