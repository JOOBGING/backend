package com.joobging.joobging.comment.service;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.board.repository.BoardRepository;
import com.joobging.joobging.comment.domain.Comment;
import com.joobging.joobging.comment.dto.CommentRequestDto;
import com.joobging.joobging.comment.repository.CommentRepository;
import com.joobging.joobging.member.domain.Member;
import com.joobging.joobging.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    // 댓글 작성
    @Transactional
    public Long saveComment(Long boardId, CommentRequestDto requestDto){
        // 댓글 저장
        Comment comment = requestDto.toEntity();
        comment.confirmMember(memberRepository.findById(requestDto.getMemberId()).orElseThrow(
                () -> new IllegalArgumentException("member not found")
        ));
        comment.confirmBoard(boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("board not found")
        ));
        return commentRepository.save(comment).getId();
    }

    // 대댓글 작성
    @Transactional
    public Long saveReComment(Long boardId, Long commentId, CommentRequestDto requestDto){
        Comment recomment = requestDto.toEntity();
        recomment.confirmMember(memberRepository.findById(requestDto.getMemberId()).orElseThrow(
                () -> new IllegalArgumentException("member not found")
        ));
        recomment.confirmBoard(boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("board not found")
        ));
        recomment.confirmParent(commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("comment not found")
        ));
        return commentRepository.save(recomment).getId();
    }
}
