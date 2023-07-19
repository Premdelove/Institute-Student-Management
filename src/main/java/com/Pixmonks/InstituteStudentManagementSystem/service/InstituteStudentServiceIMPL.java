package com.Pixmonks.InstituteStudentManagementSystem.service;
import com.Pixmonks.InstituteStudentManagementSystem.exception.ResourceNotFoundException;
import com.Pixmonks.InstituteStudentManagementSystem.model.Institute;
import com.Pixmonks.InstituteStudentManagementSystem.repository.InstituteStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class InstituteStudentServiceIMPL implements InstituteStudentService {

    @Autowired
    private InstituteStudentRepo instituteStudentRepo;

    @Override
    public Institute postInstituteStudent(Institute institute) {
        return instituteStudentRepo.save(institute);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Institute> getInstituteStudent() {
        return instituteStudentRepo.findAll();
    }

    @Override
    public Institute getInstituteStudentById(long instituteId) {
        return instituteStudentRepo.findById(instituteId).orElseThrow(
                ()->new ResourceNotFoundException(instituteId+""+"id Not Found"));
    }

    //update Institute by id
    @Override
    public Institute putInstitute(Institute institute, Long id) {

        Institute oldInstitute = instituteStudentRepo.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Id Not Found: " + id)
                );
        oldInstitute.setInstituteName(institute.getInstituteName());
        oldInstitute.setInstituteAddress(institute.getInstituteAddress());
        instituteStudentRepo.save(oldInstitute);
        return oldInstitute;

    }

    @Override
    public void deleteInstitute(Long id) {
        instituteStudentRepo.deleteById(id);
    }

//  @Override
//    public List<InstituteDTO> getInstituteOnly(Institute institute) {
//        return instituteStudentRepo.findAll().stream().map(ModelMapper.map(institute, InstituteDTO.class).collect(Collectors.toList()));
//    }
}






