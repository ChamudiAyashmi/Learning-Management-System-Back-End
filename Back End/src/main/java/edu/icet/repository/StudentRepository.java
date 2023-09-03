package edu.icet.repository;

import edu.icet.dao.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity,Long> {
    StudentEntity findByUserNameAndPassword(String userName,String password);
    Iterable<StudentEntity> findStudentById(Long id);
    Iterable<StudentEntity> findByFirstName(String firstName);

}
