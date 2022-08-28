package com.joobging.joobging.board.service;

import com.joobging.joobging.comment.domain.Comment;
import com.joobging.joobging.comment.repository.CommentRepository;
import com.joobging.joobging.review.dto.ReviewRequestDto;
import com.joobging.joobging.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl {
    private final CommentRepository commentRepository;
    @Transactional
    public Optional<Comment> findById(Long BoardId){
        Optional<Comment> cl = commentRepository.findById(BoardId);
        return cl;
    }

}
