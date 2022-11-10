package com.joobging.joobging.board.dto;

import com.joobging.joobging.board.domain.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResponseDto {

    private String title;
    private String content;
    // 회원 이름
    private String name;
    // 장소 이름
    private String locationName;

    public BoardResponseDto(Board board){
        this.title = board.getTitle();
        this.content = board.getContent();
        this.name = board.getMember().getName();
        this.locationName = board.getLocationName();
    }
}
