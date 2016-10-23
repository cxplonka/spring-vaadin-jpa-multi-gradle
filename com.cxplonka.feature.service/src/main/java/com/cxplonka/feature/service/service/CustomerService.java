/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cxplonka.feature.service.service;

import com.cxplonka.feature.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cplonka
 */
@Service(value = ICustomerService.SERVICE_NAME)
@Transactional
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepo;

}
