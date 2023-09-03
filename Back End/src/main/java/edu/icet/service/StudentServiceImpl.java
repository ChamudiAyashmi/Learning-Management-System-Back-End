package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ModelMapper modelMapper;
    public boolean isValidObject(Student student){
        StudentEntity map = modelMapper.map(student, StudentEntity.class);
        if (map.getFirstName()==null ||
                map.getLastName()==null ||
                map.getUserName()==null ||
                map.getPassword()==null ||
                map.getEmailAddress()==null ||
                map.getAddress()==null ||
                map.getPhoneNumber()==null ||
                map.getGender()==null ||
                map.getGuardiansName()==null ||
                map.getGuardiansAddress()==null ||
                map.getGuardiansPhoneNumber()==null ||
                map.getGuardiansEmail()==null ||
                map.getAge() == 0) {
            return false;
        }
        return true;
    }
    @Override
    public void registerStudent(Student student) {
        if (!isValidObject(student)){
            return;
        }else {
            StudentEntity map = modelMapper.map(student, StudentEntity.class);
            studentRepository.save(map);
        }
    }
    @Override
    public List<StudentEntity> getAllStudents() {

        return (List<StudentEntity>) studentRepository.findAll();
    }

    public boolean findStudentByUserNameAndPassword(String userName, String password){
        return studentRepository.findByUserNameAndPassword(userName,password)!=null ? true : false;
    }

    @Override
    public Iterable<StudentEntity> findStudentById(Long id) {

        return studentRepository.findStudentById(id);
    }

    @Override
    public Iterable<StudentEntity> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }
    @Override
    public boolean deleteById(Long id) {
         studentRepository.deleteById(id);
         return findById(id);
    }
    private boolean findById(Long id){

        return studentRepository.findById(id) !=null ? true: false;
    }
    @Override
    public void updateStudent(Student student) {
        StudentEntity map = modelMapper.map(student, StudentEntity.class);
        studentRepository.save(map);
    }

}
