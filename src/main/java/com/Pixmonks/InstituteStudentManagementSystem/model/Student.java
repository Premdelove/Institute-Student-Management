package com.Pixmonks.InstituteStudentManagementSystem.model;
import com.Pixmonks.InstituteStudentManagementSystem.Enum.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Student_details")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String studentName;
    private String studentAddress;
    @Enumerated(EnumType.STRING)
    private Course courseName;
    private String instituteName;

   @ManyToOne
   @JoinColumn(name = "finstitute_id")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   public Institute institute;
}
