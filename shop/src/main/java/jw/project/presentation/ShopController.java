package jw.project.presentation;

import jw.project.application.ShopService;
import jw.project.presentation.request.RegisterShopRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @PostMapping("/add")
    public void addShop(@RequestBody RegisterShopRequest request){
        shopService.register(request.toCommand());
    }

    @PostMapping("/ping")
    public String ping(){
        return "pong";
    }
}
