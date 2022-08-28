package com.joobging.joobging.board.dto;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.comment.dto.CommentResponseDto;
import com.joobging.joobging.location.domain.Location;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BoardResponseDto {

    private String title;
    private String content;
    // 회원 이름
    private String name;
    // 장소 이름
    private String loname;

    public BoardResponseDto(Board board){
        this.title = board.getTitle();
        this.content = board.getContent();
        this.name = board.getMember().getName();
        this.loname = board.getLoname();
    }
}
