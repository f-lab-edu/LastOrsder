package jw.project.presentation.request;

import jw.project.presentation.enums.Role;
import lombok.Getter;

import java.util.Set;

@Getter
public class SignupRequest {
    private String email;

    private String password;

    private String name;

    private Integer age;

    private Set<Role> role;
}
