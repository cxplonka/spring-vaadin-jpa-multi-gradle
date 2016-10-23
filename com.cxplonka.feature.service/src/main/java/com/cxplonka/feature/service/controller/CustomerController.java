/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cxplonka.feature.service.controller;

import com.cxplonka.feature.domain.Customer;
import com.cxplonka.feature.service.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cplonka
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer findOne(@PathVariable long id) {
        Assert.isTrue(id > 0, "No valid primary key.");

        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer add(@Validated @RequestBody Customer customer) {
        Assert.notNull(customer, "This field is mandatory.");

        customer.setId(null);
        return repository.saveAndFlush(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Customer update(@PathVariable long id, @Validated @RequestBody Customer customer) {
        Assert.notNull(customer, "This field is mandatory.");
        Assert.isTrue(id > 0, "No valid primary key.");

        Customer model = repository.findOne(id);
        if (model != null) {
            model.setFirstName(customer.getFirstName());
            model.setLastName(customer.getLastName());
            return repository.saveAndFlush(model);
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        Assert.isTrue(id > 0, "No valid primary key.");

        repository.delete(id);
    }
}
