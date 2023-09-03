package edu.icet.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long adminId;
    private String username;
    private String password;
    private String email;
    public void setEmail(String email) {
        if (email==null | email.isBlank()){
            return;
        }
        this.email = email;
    }
    public void setUserName(String userName) {
        if(userName==null | userName.isBlank()){
            return;
        }
        this.username = userName;
    }
    public void setPassword(String password) {
        if (password==null | password.isBlank()){
            return;
        }
        this.password = password;
    }
}
