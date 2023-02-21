package jw.project.application.command;

import jw.project.presentation.enums.Role;
import jw.project.presentation.request.SignupRequest;
import lombok.Getter;

import java.util.Set;

@Getter
public class SignupCommand {
    private String email;

    private String password;

    private String name;

    private Integer age;

    private Set<Role> role;


    public SignupCommand(SignupRequest request){
        this.email = request.getEmail();
        this.password = request.getPassword();
        this.name = request.getName();
        this.age = request.getAge();
        this.role = request.getRole();
    }
}
