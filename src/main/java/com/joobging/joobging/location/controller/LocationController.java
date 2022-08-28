package com.joobging.joobging.location.controller;

import com.joobging.joobging.location.dto.LocationOneResponseDto;
import com.joobging.joobging.location.dto.LocationResponseDto;
import com.joobging.joobging.location.service.LocationServiceImpl;
import com.joobging.joobging.review.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationServiceImpl locationService;

    @GetMapping("/{location-id}")
    public LocationResponseDto findReview(@PathVariable("location-id") Long locationId){
        return locationService.findReview(locationId);
    }

    @GetMapping()
    public List<LocationOneResponseDto> findAll(){
        return locationService.findAll();
    }

    @GetMapping("/name/{location-name}")
    public LocationOneResponseDto findLocationBy(@PathVariable("location-name") String name){
        return locationService.findLocationByName(name);
    }
}
