package jw.project.presentation.request;

import jw.project.application.command.RegisterCommand;
import lombok.Getter;

@Getter
public class RegisterShopRequest {

    private String storeName;

    private String address;

    private String description;

    private Integer minimumOrderAmount;

    private Float longitude;

    private Float latitude;

    private Long ownerId;

    public RegisterCommand toCommand(){
        return new RegisterCommand(
                this.storeName,
                this.address,
                this.description,
                this.minimumOrderAmount,
                this.longitude,
                this.latitude,
                this.ownerId
        );
    }

}
