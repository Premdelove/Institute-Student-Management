package com.Pixmonks.InstituteStudentManagementSystem.controller;

import com.Pixmonks.InstituteStudentManagementSystem.model.Order;
import com.Pixmonks.InstituteStudentManagementSystem.service.CustomerOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
public class CustomerOrdersController {
    @Autowired
    private CustomerOrders customerOrders;

    @GetMapping("/veg-customer-count")
    public Set<Long> getVegCustomerCount(){
       return   customerOrders.countCustomerWithVegOrders();


    }

}
