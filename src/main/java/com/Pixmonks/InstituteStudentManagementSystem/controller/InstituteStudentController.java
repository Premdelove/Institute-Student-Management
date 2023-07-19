package com.Pixmonks.InstituteStudentManagementSystem.controller;

import com.Pixmonks.InstituteStudentManagementSystem.exception.DataException;
import com.Pixmonks.InstituteStudentManagementSystem.model.Institute;
import com.Pixmonks.InstituteStudentManagementSystem.repository.InstituteStudentRepo;
import com.Pixmonks.InstituteStudentManagementSystem.service.InstituteStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/both")
@CrossOrigin
public class InstituteStudentController {
    @Autowired
    private InstituteStudentService instituteStudentService;

    @Autowired
    private InstituteStudentRepo instituteStudentRepo;

    //ADD Institute and Student details
    @PostMapping("/addboth")
    public ResponseEntity <?> institute(@RequestBody Institute institute) {
        Institute existInstitute = instituteStudentRepo.findByinstituteName(institute.getInstituteName());
        if (existInstitute != null) {
            return new ResponseEntity<>(" Already exist",HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(instituteStudentService.postInstituteStudent(institute), HttpStatus.CREATED);
        }
    }
    //@PostMapping("/add-institute")
    //    public ResponseEntity<?> addInstituteDetails(@RequestBody InstituteModel instituteModel){
    //
    //        InstituteModel existingName=  instituteRepository.findByinstituteName(instituteModel.getInstituteName());
    //
    //        if (existingName != null){
    //            return  new ResponseEntity<>("Already exists ",HttpStatus.INTERNAL_SERVER_ERROR);
    //
    //        }else{
    //            return new ResponseEntity<>(instituteService.saveInstituteDetails(instituteModel),HttpStatus.CREATED);


    //Get All Institute and Student details
    @GetMapping("/getAll")
    public ResponseEntity<List<Institute>>getInstituteStudent(){
        try {
            List<Institute> instituteStudent = instituteStudentService.getInstituteStudent();
            return ResponseEntity.ok(instituteStudent);
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
//return instituteStudentService.getInstituteStudent();
    }


    //UPDATE Institute details only
    @PutMapping("/updateInstitute/{id}")
    public ResponseEntity<Institute>updateInstituteAndStudent(@RequestBody Institute institute,
                                                              @PathVariable("id") long id){
        return new ResponseEntity<Institute>(instituteStudentService.putInstitute(institute, id), HttpStatus.OK);
    }

    //getInstituteOnly
    @DeleteMapping("/institutions/checkBox/{id}")
    public ResponseEntity<?> deleteInstitutes(@PathVariable @RequestBody String id){
        List<Long> idList = Arrays.stream(id.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
//        instituteStudentService.deleteInstitute(idList);

        for (Long ids : idList) {
            Institute deleteid = instituteStudentService.getInstituteStudentById(ids);

                if (deleteid.getStudent().isEmpty()) {
                    instituteStudentService.deleteInstitute(ids);
                    return ResponseEntity.ok("");
                } else {

                    return new ResponseEntity<>(new DataException("Student is present in this institute cant be deleted",400),HttpStatus.BAD_REQUEST);
                }
//            } catch (Exception e) {
//               return new ResponseEntity<>(new Exception("Student is present in this institute cant be deleted",400),HttpStatus.BAD_REQUEST);
//             //   return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Student is present in this institute cant be deleted");
//            }

        }
   return null;
    }


//    @DeleteMapping("deleteStudent/{id}")
//    public  ResponseEntity<String> deleteStudentById(@PathVariable Long id){
//        try {
//            studentService.deleteStudentById(id);
//            return ResponseEntity.ok("Student Deleted Successfully.");
//        }
//        catch (EmptyResultDataAccessException e) {
//            return ResponseEntity.notFound().build();
//        }
//        catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Student, try again");
//        }
//    }
}
