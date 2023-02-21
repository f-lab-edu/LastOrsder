package jw.project.presentation.request;

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

}
