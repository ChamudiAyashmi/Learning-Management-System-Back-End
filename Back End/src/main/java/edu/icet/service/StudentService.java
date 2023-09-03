package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import java.util.List;

public interface StudentService {
    void registerStudent(Student student);
    public List<StudentEntity> getAllStudents();
    boolean findStudentByUserNameAndPassword(String userName, String password);
    Iterable<StudentEntity> findStudentById(Long id);
    Iterable<StudentEntity> findByFirstName(String firstName);
    boolean deleteById(Long id);
    void updateStudent(Student student);

}
