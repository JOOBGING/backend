package com.joobging.joobging.review.dto;

import com.joobging.joobging.member.domain.Member;
import com.joobging.joobging.review.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewRequestDto {

    private String content;
    private Long star;
    private Long mid; // member_id

    @Builder
    public ReviewRequestDto(String content, Long star, Long mid){
        this.content = content;
        this.star = star;
        this.mid = mid;
    }

    public Review toEntity(Member member){
        return Review.builder()
                .content(content)
                .star(star)
                .member(member)
                .build();
    }

}
