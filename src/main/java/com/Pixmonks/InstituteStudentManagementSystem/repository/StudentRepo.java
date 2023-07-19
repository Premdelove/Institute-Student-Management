package com.Pixmonks.InstituteStudentManagementSystem.repository;

import com.Pixmonks.InstituteStudentManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
