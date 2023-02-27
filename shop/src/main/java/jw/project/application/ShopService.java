package jw.project.application;

import jw.project.application.command.RegisterCommand;
import jw.project.domain.Shop;
import jw.project.infrastructure.JpaShopRepository;
import jw.project.infrastructure.dynamoDB.ShopUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final JpaShopRepository shopRepository;
    private final ShopUsersRepository shopUsersRepository;
    public void register(RegisterCommand command){
        Long id = shopRepository.save(Shop.register(command)).getId();
        shopUsersRepository.addUser(id, 1L);
    }
}
