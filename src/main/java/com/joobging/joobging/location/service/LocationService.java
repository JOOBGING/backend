package com.joobging.joobging.location.service;

import com.joobging.joobging.location.dto.LocationOneResponseDto;
import com.joobging.joobging.location.dto.LocationResponseDto;
import com.joobging.joobging.review.dto.ReviewResponseDto;

import java.util.List;

public interface LocationService {

    // 각 location의 리뷰 모아 보기
    LocationResponseDto findReview(Long locationId);


    // location 전부 조회
    List<LocationOneResponseDto> findAll();

    // location 단건 조회
}
