package com.Pixmonks.InstituteStudentManagementSystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table(name = "customerTable")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String customerName;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    public List<Order>orders;
}
