package jw.project.presentation;

import jw.project.presentation.request.RegisterShopRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @PostMapping("/addShop")
    public void addShop(@RequestBody RegisterShopRequest request){
        //shopSerivce.register(request);
    }
}
