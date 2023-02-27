package jw.project.application;

import jw.project.application.command.SignupCommand;
import jw.project.domain.Account;
import jw.project.infrastructure.JpaAccountRepository;
import jw.project.infrastructure.dynamoDB.entity.KeywordUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final JpaAccountRepository accountRepository;

    private final KeywordUsersRepository keywordUsersRepository;

    public void signup(SignupCommand command) {
        accountRepository.save(Account.register(command));
    }

    public void addKeyword(String accountId, String keyword) {
        keywordUsersRepository.addUser(keyword, accountId);
    }

    public String findUser(){
        return accountRepository.findByEmail("poujis@naver.com").toString();
    }
}
