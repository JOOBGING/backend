package com.joobging.joobging.comment.controller;

import com.joobging.joobging.comment.dto.CommentRequestDto;
import com.joobging.joobging.comment.repository.CommentRepository;
import com.joobging.joobging.comment.service.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentServiceImpl commentService;

    @PostMapping("/{board-id}")
    public Long saveComment(@RequestBody CommentRequestDto requestDto, @PathVariable("board-id") Long boardId){
        return commentService.saveComment(boardId,requestDto);
    }

    @PostMapping("/{board-id}/{comment-id}")
    public Long saveRecomment(@RequestBody CommentRequestDto requestDto, @PathVariable("board-id") Long boardId,
                              @PathVariable("comment-id") Long commentId){
        return commentService.saveReComment(boardId,commentId,requestDto);
    }
}
