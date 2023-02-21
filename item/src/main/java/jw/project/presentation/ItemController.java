package jw.project.presentation;

import jw.project.application.ItemService;
import jw.project.presentation.request.AddItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add")
    public void addItem(@RequestBody AddItemRequest request){
        itemService.addItem(request.toCommand());
    }
}
