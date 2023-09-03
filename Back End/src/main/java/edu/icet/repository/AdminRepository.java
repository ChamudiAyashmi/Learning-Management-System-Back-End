package edu.icet.repository;

import edu.icet.dao.AdminEntity;
import edu.icet.dto.Admin;
import org.springframework.data.repository.CrudRepository;
public interface AdminRepository extends CrudRepository<AdminEntity,Long> {
    AdminEntity findByUsernameAndPassword(String username, String password);
}
