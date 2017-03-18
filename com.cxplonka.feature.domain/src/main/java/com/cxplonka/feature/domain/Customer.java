package com.cxplonka.feature.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Customer { 

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable=false,length=30)
    @Basic(fetch = FetchType.LAZY)
    @NotNull
    @Size(min=1,max=30)
    private String firstName;

    @Column(nullable=false,length=30)
    @Basic(fetch = FetchType.LAZY)
    @NotNull
    @Size(min=1,max=30)
    private String lastName;


    public Customer(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Customer(){
// default constructor for hibernate/jaxb
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Customer{" + " id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

}
