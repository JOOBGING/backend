package com.joobging.joobging.board.dto;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.member.domain.Member;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Getter
public class BoardUpdateDto {
    private String title;
    private String content;
    private String map;
    private String locationName;

    public Board toEntity(Member member){
        Board board = new Board();
        board.setId(board.getId());
        board.setTitle(title);
        board.setContent(content);
        board.setMap(map);
        board.setLocationName(locationName);
        board.setMember(member);
        return board;
    }


}
