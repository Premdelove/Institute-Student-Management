package com.Pixmonks.InstituteStudentManagementSystem.service;

import com.Pixmonks.InstituteStudentManagementSystem.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudent();

     Optional <Student> updateStudentById(Student student, long id);

     void deleteStudentById(long id);

     //checkbox
     public void deleteStudent(Iterable<Long> id);
}
