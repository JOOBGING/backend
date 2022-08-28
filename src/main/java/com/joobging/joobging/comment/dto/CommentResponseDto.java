package com.joobging.joobging.comment.dto;

import com.joobging.joobging.comment.domain.Comment;
import jdk.nashorn.api.tree.CompilationUnitTree;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CommentResponseDto {


    private String name;
    private String mbti;
    private String content;
    private List<CommentResponseDto> commentResponseDtoList;

    public CommentResponseDto(Comment comment){
        this.name = comment.getMember().getName();
        this.mbti = comment.getMember().getMbti();
        this.content = comment.getContent();
        this.commentResponseDtoList = comment.getChildren().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }

}
