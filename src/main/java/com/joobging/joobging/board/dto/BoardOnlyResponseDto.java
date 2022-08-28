package com.joobging.joobging.board.dto;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.comment.dto.CommentResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BoardOnlyResponseDto {

    private String title;
    private String content;
    // 회원 이름
    private String name;
    // 장소 이름
    private String loname;
    private List<CommentResponseDto> commentResponseDtoList;


    public BoardOnlyResponseDto(Board board){
        this.title = board.getTitle();
        this.content = board.getContent();
        this.name = board.getMember().getName();
        this.loname = board.getLoname();
        this.commentResponseDtoList = board.getCommentList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
