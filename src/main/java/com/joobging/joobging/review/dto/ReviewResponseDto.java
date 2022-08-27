package com.joobging.joobging.review.dto;

import com.joobging.joobging.review.domain.Review;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponseDto {

    private Long id;
    private String content;
    private Long star;
    private String name;

    public ReviewResponseDto(Review review){
        this.id = review.getId();
        this.content = review.getContent();
        this.star = review.getStar();
        this.name = review.getMember().getName();
    }


}
