package bruff.eventuff.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario extends Pessoa {
    private String email;
    private String password;
    private String role;

    public Usuario() {
        super();
    }

    // Getters and Setters for additional fields
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
