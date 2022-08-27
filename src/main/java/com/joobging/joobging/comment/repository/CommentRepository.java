package com.joobging.joobging.comment.repository;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Override
    List<Comment> findAll();
    void deleteById(Long aLong);
}
