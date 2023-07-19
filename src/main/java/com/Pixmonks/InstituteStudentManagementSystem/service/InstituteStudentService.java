package com.Pixmonks.InstituteStudentManagementSystem.service;

import com.Pixmonks.InstituteStudentManagementSystem.model.Institute;

import java.util.List;

public interface InstituteStudentService {
    public Institute postInstituteStudent(Institute institute);

    public List<Institute> getInstituteStudent();

    Institute getInstituteStudentById(long instituteId);


    Institute putInstitute(Institute institute,Long id);


//    List<InstituteDTO> getInstituteOnly(Institute institute);
    public void deleteInstitute(Long id);
}
