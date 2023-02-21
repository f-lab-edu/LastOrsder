package jw.project.presentation;

import jw.project.application.AccountService;
import jw.project.application.command.SignupCommand;
import jw.project.presentation.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        accountService.signup(new SignupCommand(request));
    }
}
