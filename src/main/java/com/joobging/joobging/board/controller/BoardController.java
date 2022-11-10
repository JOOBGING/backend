package com.joobging.joobging.board.controller;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.board.dto.BoardOneResponseDto;
import com.joobging.joobging.board.dto.BoardResponseDto;
import com.joobging.joobging.board.dto.BoardSaveDto;
import com.joobging.joobging.board.dto.BoardUpdateDto;
import com.joobging.joobging.board.repository.BoardRepository;
import com.joobging.joobging.board.service.BoardServiceImpl;
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

    @DeleteMapping("/board/{id}")
    public int deleteById(@PathVariable Long id){
        boardRepository.deleteById(id);
        return 1; //1:성공, -1:실패
    }

    @GetMapping("/board/{id}")
    public BoardOneResponseDto findById(@PathVariable Long id) {
        return boardService.findById(id);
    }
//    @GetMapping("/board/{id}/comment")
//    public Comment findCommentById(@PathVariable Long id) {
//        return boardService.findById(id).get();
//    }


    @GetMapping("/board")
    public List<BoardResponseDto> findAll(){
        return boardService.findAll();
    }

    @PostMapping("/board")
    public Board save(@RequestBody BoardSaveDto dto) {
        Optional<Member> findMember = memberRepository.findById(dto.getMemberId());
        Board boardEntity = boardRepository.save(dto.toEntity(findMember.get()));
        return boardEntity;
    }

    @PutMapping("/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateDto boardUpdateDto) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.update(boardUpdateDto.getTitle(), board.getContent(), board.getMap(), board.getLocationName());
        return board.getId();
    }
}
