package com.joobging.joobging.review.dto;

import com.joobging.joobging.location.domain.Location;
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
    private Long member; // member_id
    private Long location; // location_id

    @Builder
    public ReviewRequestDto(String content, Long star, Long member, Long location){
        this.content = content;
        this.star = star;
        this.member = member;
        this.location = location;
    }

    public Review toEntity(Member member, Location location){
        return Review.builder()
                .content(content)
                .star(star)
                .member(member)
                .location(location)
                .build();
    }

}
