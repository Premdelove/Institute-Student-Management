package com.Pixmonks.InstituteStudentManagementSystem.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;

@Entity
@Data
@Table(name = "orderTable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String value;
    private String isVeg;
    private String orderedDate;

    @ManyToOne
    @JoinColumn(name = "f_orderId")
    public Customer customer;
}
