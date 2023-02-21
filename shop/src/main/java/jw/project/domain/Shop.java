package jw.project.domain;

import jakarta.persistence.*;
import jw.project.application.command.RegisterCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_shop")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String storeName;

    private String address;

    private String description;

    private Integer minimumOrderAmount;

    private Float longitude;

    private Float latitude;

    private Long ownerId;

    private Shop(RegisterCommand command) {
        this.storeName = command.getStoreName();
        this.address = command.getAddress();
        this.description = command.getDescription();
        this.minimumOrderAmount = command.getMinimumOrderAmount();
        this.longitude = command.getLongitude();
        this.latitude = command.getLatitude();
        this.ownerId = command.getOwnerId();
    }

    public static Shop register(RegisterCommand command){
        return new Shop(command);

    }
}
