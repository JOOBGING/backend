package com.joobging.joobging.board.dto;
import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.member.domain.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor

public class BoardSaveDto {
    private String title;
    private String content;
    private Long id;
    private String map;
    private Long memberId; // 멤버 아이디 받아오기

    @Builder
    public BoardSaveDto(String title, String content, Long id, String map, Long memberId) {
        this.title = title;
        this.content = content;
        this.id = id;
        this.map = map;
        this.memberId = memberId;
    }

    public Board toEntity(Member member){
        Board board = new Board();
        board.setId(id);
        board.setTitle(title);
        board.setContent(content);
        board.setMap(map);
        board.setMember(member);
        return board;
    }

}