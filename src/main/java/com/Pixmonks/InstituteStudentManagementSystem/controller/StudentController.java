package com.Pixmonks.InstituteStudentManagementSystem.controller;

import com.Pixmonks.InstituteStudentManagementSystem.model.Student;
import com.Pixmonks.InstituteStudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Add new Student
    @PostMapping("/addStudent")

    public ResponseEntity<Student> studentResponseEntity(@RequestBody Student student) {

        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }


    //Get All Student
    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(Student student) {
        return studentService.getAllStudent();
    }

    //update student by id
    @PutMapping("/updateStudent/{id}")
    public Optional<Student> updateStudentById(@RequestBody Student student,
                                               @PathVariable("id") long id) {
        return studentService.updateStudentById(student,id);

    }

    // To DELETE Student By Id

    @DeleteMapping("deleteStudent/{id}")
    public  ResponseEntity<String> deleteStudentById(@PathVariable Long id){
        try {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok("Student Deleted Successfully.");
        }
        catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Student, try again");
        }
        }
    @DeleteMapping("/students/checkBox/{id}")
    public void deleteStudents(@PathVariable @RequestBody String id) {
                List<Long> idList = Arrays.stream(id.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        studentService.deleteStudent(idList);
    }

}






