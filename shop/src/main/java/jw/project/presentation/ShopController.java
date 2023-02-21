package jw.project.presentation;

import jw.project.application.ShopService;
import jw.project.presentation.request.RegisterShopRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @PostMapping("/add")
    public void addShop(@RequestBody RegisterShopRequest request){
        shopService.register(request.toCommand());
    }
}
