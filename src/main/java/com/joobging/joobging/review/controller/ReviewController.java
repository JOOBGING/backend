package com.joobging.joobging.review.controller;

import com.joobging.joobging.review.dto.ReviewRequestDto;
import com.joobging.joobging.review.dto.ReviewResponseDto;
import com.joobging.joobging.review.service.ReviewService;
import com.joobging.joobging.review.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    // review 작성
    @PostMapping("")
    public Long save(@RequestBody ReviewRequestDto requestDto){
        return reviewService.save(requestDto);
    }

    // review 삭제
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") Long id){
        return reviewService.delete(id);
    }

    // review 조회
    @GetMapping("")
    public List<ReviewResponseDto> findAll(){
        return reviewService.findAll();
    }

}
