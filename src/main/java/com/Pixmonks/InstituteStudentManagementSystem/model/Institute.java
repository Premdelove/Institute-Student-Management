package com.Pixmonks.InstituteStudentManagementSystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "institute_details")
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instituteId;
    private String instituteName;
    private String instituteAddress;
    @OneToMany(mappedBy = "institute",cascade = CascadeType.ALL)
   // @JoinColumn(name="f_key", referencedColumnName = "instituteId")
    public List<Student> student;
}
