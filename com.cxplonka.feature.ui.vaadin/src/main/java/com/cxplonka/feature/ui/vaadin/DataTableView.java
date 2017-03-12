/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cxplonka.feature.ui.vaadin;

import com.cxplonka.feature.domain.Customer;
import com.cxplonka.feature.service.repository.CustomerRepository;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 *
 * @author cplonka
 */
@SpringView(name = DataTableView.VIEW_NAME)
public class DataTableView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "vaadin.data.table.ui";

    @Autowired
    private CustomerRepository repo;

    private final Grid<Customer> grid;

    public DataTableView() {
        this.grid = new Grid(Customer.class);
    }

    @PostConstruct
    void init() {
        initLayout();
    }

    private void initLayout() {
        setMargin(true);
        setSpacing(true);
        setSizeFull();

        TextField filter = new TextField("Filter by last name");
        filter.addValueChangeListener(e -> filterCustomers(e.getValue()));

        filterCustomers(null);
        grid.setSizeFull();

        addComponent(filter);
        addComponent(grid);
    }

    private void filterCustomers(String lastName) {
        if (StringUtils.isEmpty(lastName)) {
            grid.setItems(repo.findAll());
        } else {
            grid.setItems(repo.findByLastNameStartsWithIgnoreCase(lastName));
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
