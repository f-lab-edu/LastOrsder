package jw.project.domain;

import jw.project.application.command.SignupCommand;
import jw.project.presentation.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_user")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private Integer age;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    private Account(SignupCommand command){
        this.email = command.getEmail();
        this.password = command.getPassword();
        this.name = command.getName();
        this.age = command.getAge();
        this.role = command.getRole();
    }

    public static Account register(SignupCommand command){
        return new Account(command);
    }
}
