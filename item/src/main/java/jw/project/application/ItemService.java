package jw.project.application;

import jw.project.application.command.AddItemCommand;
import jw.project.domain.Item;
import jw.project.infrastructure.JpaItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {
    private final SQSService sqsService;

    private final JpaItemRepository itemRepository;

    public void addItem(AddItemCommand command) {
        itemRepository.save(Item.addItem(command));
        sqsService.sendMessage(command.getName());
    }
}
