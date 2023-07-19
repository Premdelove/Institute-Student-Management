package com.Pixmonks.InstituteStudentManagementSystem.service;

import com.Pixmonks.InstituteStudentManagementSystem.model.Order;
import com.Pixmonks.InstituteStudentManagementSystem.repository.CustomerRepo;
import com.Pixmonks.InstituteStudentManagementSystem.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerOrders {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

   public Set<Long>   countCustomerWithVegOrders(){
       List<Order> vegOrder = orderRepo.findByIsVeg("veg");
       Set<Long> customerIds = new HashSet<>();

       for(Order order : vegOrder){
           customerIds.add(Long.valueOf(order.getValue()));
       }
       return customerIds;
    }

}
