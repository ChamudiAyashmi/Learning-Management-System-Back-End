package edu.icet.service;

import edu.icet.dao.AdminEntity;
import edu.icet.dto.Admin;

public interface AdminService {
    public boolean saveAdmin(Admin admin);
    boolean findAdminByUsernameAndPassword(String username, String password);
}
