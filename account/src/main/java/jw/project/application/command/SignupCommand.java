package jw.project.application.command;

import lombok.Getter;

@Getter
public class SignupCommand {
    String email;
    String password;

    public SignupCommand(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
