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


    private String role = "ROLE_USER";

    @Column(columnDefinition = "integer default 1")
    private int visible;
}
