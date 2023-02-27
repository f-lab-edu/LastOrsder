package jw.project.presentation;

import jw.project.application.AccountService;
import jw.project.application.command.SignupCommand;
import jw.project.presentation.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        accountService.signup(new SignupCommand(request));
    }

    @PostMapping("/keyword")
    public void addKeyword(String accountId, String keyword) {
        accountService.addKeyword(accountId, keyword);
    }

    @GetMapping("/user")
    public String findUser(){
        return accountService.findUser();
    }

    @PostMapping("ping")
    public String pong(){
        return "pong";
    }
}
