package com.joobging.joobging.board.dto;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.comment.dto.CommentResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BoardOneResponseDto {

    private String title;
    private String content;
    private String memberName;
    private String locationName;
    private List<CommentResponseDto> commentResponseDtoList;


    public BoardOneResponseDto(Board board){
        this.title = board.getTitle();
        this.content = board.getContent();
        this.memberName = board.getMember().getName();
        this.locationName = board.getLocationName();
        this.commentResponseDtoList = board.getCommentList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
