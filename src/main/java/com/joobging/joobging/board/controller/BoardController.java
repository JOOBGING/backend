package com.joobging.joobging.board.controller;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.board.dto.BoardSaveDto;
import com.joobging.joobging.board.repository.BoardRepository;
import com.joobging.joobging.board.service.BoardServiceImpl;
import com.joobging.joobging.comment.domain.Comment;
import com.joobging.joobging.member.domain.Member;
import com.joobging.joobging.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    private final BoardServiceImpl boardService;

    /* @PutMapping("/board/{id}")
    public void update(@RequestBody BoardSaveDto dto, @PathVariable Long id){
        Board board = dto.toEntity();
        board.setId(id);
        boardRepository.save(board);
    } */

    @DeleteMapping("/board/{id}")
    public int deleteById(@PathVariable Long id){
        boardRepository.deleteById(id);
        return 1; //1:성공, -1:실패
    }

    @GetMapping("/board/{id}")
    public Board findById(@PathVariable Long id) {

        return boardRepository.findById(id).get();
    }
    @GetMapping("/board/{id}/comment")
    public Comment findCommentById(@PathVariable Long id) {
        return boardService.findById(id).get();
    }


    @GetMapping("/board")
    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    @PostMapping("/board")
    public Board save(@RequestBody BoardSaveDto dto) {
        Optional<Member> findMember = memberRepository.findById(dto.getMemberId());
        //{"title":"제목","content":"내용"}
        //@RequsetBody 어노테이션을 붙인 이유는 json 타입으로 데이터를 받기 위함.
        Board boardEntity = boardRepository.save(dto.toEntity(findMember.get()));
        return boardEntity;
    }
}
