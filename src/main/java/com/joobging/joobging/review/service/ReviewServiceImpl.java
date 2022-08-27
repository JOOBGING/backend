package com.joobging.joobging.review.service;

import com.joobging.joobging.member.domain.Member;
import com.joobging.joobging.member.repository.MemberRepository;
import com.joobging.joobging.review.domain.Review;
import com.joobging.joobging.review.dto.ReviewRequestDto;
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
public class ReviewServiceImpl implements ReviewService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    // 작성
    @Transactional
    public Long save(ReviewRequestDto requestDto){

        // 멤버 찾기
        Optional<Member> member = memberRepository.findById(requestDto.getMid());
        if(member.isEmpty()){
            throw new IllegalArgumentException("member not found");
        }
        // 리뷰 만들기
        Review review = requestDto.toEntity(member.get());
        reviewRepository.save(review);
        return  review.getId();

    }

    // 삭제
    @Transactional
    public Long delete(Long id){
        Review review = reviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("review not found"));
        reviewRepository.delete(review);
        return review.getId();
    }

    // 조회
    public List<ReviewResponseDto> findAll(){
        List<Review> reviewList = reviewRepository.findAllDesc();
        return reviewList.stream()
                .map(ReviewResponseDto::new)
                .collect(Collectors.toList());
    }

}
