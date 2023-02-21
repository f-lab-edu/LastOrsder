package jw.project.presentation.request;

import jw.project.application.command.AddItemCommand;
import lombok.Getter;

@Getter
public class AddItemRequest {
    private String name;

    private Integer price;

    private String description;

    private Integer stack;

    private Long storeId;

    public AddItemCommand toCommand(){
        return new AddItemCommand(
                this.name,
                this.price,
                this.description,
                this.stack,
                this.storeId
        );
    }
}
