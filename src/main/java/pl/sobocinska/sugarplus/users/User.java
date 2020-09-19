package pl.sobocinska.sugarplus.users;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 3, max = 15)
    @NotBlank(message = "Pole nie może być puste.")
    private String name;

    @Length(min = 5, max = 20)
    @NotBlank(message = "Pole nie może być puste.")
    private String surname;

    @Length(min = 5, max = 15)
    @Column(unique = true)
    @NotBlank(message = "Pole nie może być puste.")
    private String username;

    @NotBlank(message = "Pole nie może być puste.")
    private String password;

    @Email(message = "Podano nieprawidłowy e-mail.")
    @NotBlank(message = "Te pole jest wymagane.")
    private String email;


    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    private boolean visible = Boolean.TRUE;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
