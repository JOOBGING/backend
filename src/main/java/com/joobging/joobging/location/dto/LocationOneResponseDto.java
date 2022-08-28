package com.joobging.joobging.location.dto;

import com.joobging.joobging.location.domain.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationOneResponseDto {

    private String name;
    private Double latitude;//위도
    private Double longitude;//경도

    public LocationOneResponseDto(Location entity){
        this.name = entity.getName();
        this.latitude = entity.getLatitude(); // 위도
        this.longitude = entity.getLongitude(); // 경도
    }

}
