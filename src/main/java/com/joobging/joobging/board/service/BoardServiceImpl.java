package com.joobging.joobging.board.service;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.board.dto.BoardOneResponseDto;
import com.joobging.joobging.board.dto.BoardResponseDto;
import com.joobging.joobging.board.repository.BoardRepository;
import com.joobging.joobging.comment.domain.Comment;
import com.joobging.joobging.comment.dto.CommentResponseDto;
import com.joobging.joobging.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;


    @Transactional
//    public Optional<Comment> findById(Long BoardId){
//        Optional<Comment> cl = commentRepository.findById(BoardId);
//        return cl;
//    }


    // board 목록 조회
    public List<BoardResponseDto> findAll(){
        List<Board> board = boardRepository.findAll();
        return board.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    // board 단건 조회
    public BoardOneResponseDto findById(Long id){
        Optional<Board> board = boardRepository.findById(id);
        List<Comment> commentList = commentRepository.findByComment_IdOrderByCreatedDateDesc(id);
        BoardOneResponseDto responseDto = new BoardOneResponseDto(board.get());
        responseDto.setCommentResponseDtoList(commentList.stream().map(CommentResponseDto::new).collect(Collectors.toList()));
        return responseDto;
    }
}
