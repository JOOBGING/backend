package com.joobging.joobging.board.service;

import com.joobging.joobging.comment.domain.Comment;
import com.joobging.joobging.review.dto.ReviewRequestDto;

import java.util.Optional;

public interface BoardService {
    Optional<Comment> findById(Long BoardId);
}
