package com.joobging.joobging.location.dto;

import com.joobging.joobging.location.domain.Location;
import com.joobging.joobging.review.dto.ReviewResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LocationResponseDto {

    private String name;
    private Double latitude;//위도
    private Double longitude;//경도
    private List<ReviewResponseDto> reviewResponseDtoList;

    public LocationResponseDto(Location location){
        this.name = location.getName();
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
        this.reviewResponseDtoList = location.getReviewList().stream().map(ReviewResponseDto::new).collect(Collectors.toList());
    }
}
