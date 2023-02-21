package jw.project.application.command;

import lombok.Getter;

@Getter
public class RegisterCommand {
    private String storeName;

    private String address;

    private String description;

    private Integer minimumOrderAmount;

    private Float longitude;

    private Float latitude;

    private Long ownerId;

    public RegisterCommand(String storeName, String address, String description, Integer minimumOrderAmount, Float longitude, Float latitude, Long ownerId) {
        this.storeName = storeName;
        this.address = address;
        this.description = description;
        this.minimumOrderAmount = minimumOrderAmount;
        this.longitude = longitude;
        this.latitude = latitude;
        this.ownerId = ownerId;
    }
}
