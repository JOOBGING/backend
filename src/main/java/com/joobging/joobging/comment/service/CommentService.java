package com.joobging.joobging.comment.service;

import com.joobging.joobging.comment.dto.CommentRequestDto;

import java.util.spi.LocaleNameProvider;

public interface CommentService {

    // 댓글 작성
    Long saveComment(Long boardId, CommentRequestDto requestDto);

    // 대댓글 작성
    Long saveReComment(Long boardId, Long commentId, CommentRequestDto requestDto);
}
