package jw.project.application;

import jw.project.application.command.SignupCommand;
import jw.project.domain.Account;
import jw.project.infrastructure.JpaAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final JpaAccountRepository accountRepository;

    public void signup(SignupCommand command) {
        accountRepository.save(Account.register(command));
    }
}
