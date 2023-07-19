package com.Pixmonks.InstituteStudentManagementSystem.repository;

import com.Pixmonks.InstituteStudentManagementSystem.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteStudentRepo extends JpaRepository<Institute, Long> {

    //For bidirection
    public Institute findByinstituteName(String instituteName);
}
