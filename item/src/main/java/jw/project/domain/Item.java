package jw.project.domain;

import jw.project.application.command.AddItemCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "tb_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;

    private Integer price;

    private String description;

    private Integer stack;

    private Long storeId;

    private Item(AddItemCommand command) {
        this.name = command.getName();
        this.price = command.getPrice();
        this.description = command.getDescription();
        this.stack = command.getStack();
        this.storeId = command.getStoreId();
    }

    public static Item addItem(AddItemCommand command){
        return new Item(command);
    }
}
