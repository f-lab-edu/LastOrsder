package jw.project.application;

import jw.project.application.command.RegisterCommand;
import jw.project.domain.Shop;
import jw.project.infrastructure.JpaShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final JpaShopRepository shopRepository;
    public void register(RegisterCommand command){
        shopRepository.save(Shop.register(command));
    }
}
