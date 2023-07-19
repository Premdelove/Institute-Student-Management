package com.Pixmonks.InstituteStudentManagementSystem.repository;

import com.Pixmonks.InstituteStudentManagementSystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
//    @Query("SELECT o FROM Order o WHERE o.value = (SELECT MAX(o.value) FROM Order o)")
//    List<Order> findByValue(@Param("value")String value);
       List<Order> findByIsVeg(String isVeg);

}
