package com.Pixmonks.InstituteStudentManagementSystem.service;

import com.Pixmonks.InstituteStudentManagementSystem.model.Institute;
import com.Pixmonks.InstituteStudentManagementSystem.model.Student;
import com.Pixmonks.InstituteStudentManagementSystem.repository.InstituteStudentRepo;
import com.Pixmonks.InstituteStudentManagementSystem.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIMPL implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    //Bi derection method
   @Autowired
   private InstituteStudentRepo instituteStudentRepo;
    @Override
    public Student saveStudent(Student student) {
        Institute institute = instituteStudentRepo.findByinstituteName(student.getInstituteName());
        student.setInstitute(institute);
        return studentRepo.save(student);
    }
    //********

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> updateStudentById(Student student, long id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        optionalStudent.ifPresent(updateStudent -> {
            updateStudent.setStudentName(student.getStudentName());
//            updateStudent.setStudentCourse(student.getStudentCourse());
            updateStudent.setStudentAddress(student.getStudentAddress());
            updateStudent.setInstituteName(student.getInstituteName());
            studentRepo.save(updateStudent);
        });
        return optionalStudent;
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepo.deleteById(id);
    }

    /**
     * Delete method
     * @param id
     */
    @Override
    public void deleteStudent(Iterable<Long> id) {
        studentRepo.deleteAllByIdInBatch(id);
    }


}
