package com.joobging.joobging.location.service;

import com.joobging.joobging.location.domain.Location;
import com.joobging.joobging.location.dto.LocationOneResponseDto;
import com.joobging.joobging.location.dto.LocationResponseDto;
import com.joobging.joobging.location.repository.LocationRepository;
import com.joobging.joobging.review.domain.Review;
import com.joobging.joobging.review.dto.ReviewResponseDto;
import com.joobging.joobging.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService{

    private final LocationRepository locationRepository;
    private final ReviewRepository reviewRepository;

    // 각 location 마다 리뷰 조회
    public LocationResponseDto findReview(Long locationId){
        Optional<Location> location = locationRepository.findById(locationId);
        if(location.isEmpty()){
            throw new IllegalArgumentException("location not found");
        }
        List<Review> reviewList = reviewRepository.findByReview_Id(locationId);
        if(reviewList.isEmpty()){
            throw new IllegalArgumentException("review not found");
        }
        List<ReviewResponseDto> reviewResponseDtoList = reviewList.stream().map(ReviewResponseDto::new).collect(Collectors.toList());
        LocationResponseDto locationResponseDto = new LocationResponseDto(location.get());
        locationResponseDto.setReviewResponseDtoList(reviewResponseDtoList);
        return locationResponseDto;
    }

    // location 조회
    public List<LocationOneResponseDto> findAll(){
        List<Location> locationList = locationRepository.findAll();
        return locationList.stream().map(LocationOneResponseDto::new).collect(Collectors.toList());
    }


    // location 이름 받으면 정보 띄워주기 -> id, latitude, longitude, name
    public LocationOneResponseDto findLocationByName(String name){
        Optional<Location> location = locationRepository.findByName(name);
        LocationOneResponseDto locationOneResponseDto = new LocationOneResponseDto(location.get());
        return locationOneResponseDto;
    }

}
