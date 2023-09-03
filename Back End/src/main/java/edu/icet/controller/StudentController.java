package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public void saveStudent(@RequestBody Student student) throws IOException, SQLException {
        studentService.registerStudent(student);
    }
    @GetMapping
    public List<StudentEntity> getAllStudents(){

        return studentService.getAllStudents();
    }
    @GetMapping("/{userName}/{password}")
    public boolean findStudentByUserNameAndPassword(@PathVariable String userName, @PathVariable String password){
        boolean studentByUserNameAndPassword = studentService.findStudentByUserNameAndPassword(userName, password);
        System.out.println(studentByUserNameAndPassword);
        return studentByUserNameAndPassword;
    }

    @GetMapping("/{id}")
    public Iterable<StudentEntity> findStudentById(@PathVariable Long id){

        return studentService.findStudentById(id);
    }
    @GetMapping("/byFirstName/{firstName}")
    public Iterable<StudentEntity> findStudentByFirstName(@PathVariable String firstName){
        return studentService.findByFirstName(firstName);
    }
    @DeleteMapping("/{id}")
    public boolean deleteAdminById(@PathVariable String id){
        return studentService.deleteById(Long.valueOf(id));
    }


    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }
}
