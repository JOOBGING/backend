package com.joobging.joobging.comment.dto;

import com.joobging.joobging.comment.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDto {

    private String content;
    private Long memberId;

    @Builder
    public CommentRequestDto(String content, Long memberId){
        this.content = content;
        this.memberId = memberId;
    }

    public Comment toEntity(){
        return Comment.builder()
                .content(content)
                .build();
    }
}
