package com.joobging.joobging.review.service;

import com.joobging.joobging.review.dto.ReviewRequestDto;
import com.joobging.joobging.review.dto.ReviewResponseDto;

import java.util.List;

public interface ReviewService {

    // 작성
    Long save(ReviewRequestDto requestDto);

    // 조회
    List<ReviewResponseDto> findAll();

    // 단건 조회

    // 삭제
    Long delete(Long id);

    // 별점올리기

    // 별점내리기
}
