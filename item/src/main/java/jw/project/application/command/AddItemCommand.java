package jw.project.application.command;

import lombok.Getter;

@Getter
public class AddItemCommand {
    private String name;

    private Integer price;

    private String description;

    private Integer stack;

    private Long storeId;

    public AddItemCommand(String name, Integer price, String description, Integer stack, Long storeId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stack = stack;
        this.storeId = storeId;
    }
}
