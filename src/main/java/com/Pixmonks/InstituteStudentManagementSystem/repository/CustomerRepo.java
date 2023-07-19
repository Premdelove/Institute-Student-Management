package com.Pixmonks.InstituteStudentManagementSystem.repository;

import com.Pixmonks.InstituteStudentManagementSystem.model.Customer;
import com.Pixmonks.InstituteStudentManagementSystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

}
