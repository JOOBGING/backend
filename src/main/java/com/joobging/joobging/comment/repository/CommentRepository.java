package com.joobging.joobging.comment.repository;

import com.joobging.joobging.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Override
    Optional<Comment> findById(Long aLong);
}
