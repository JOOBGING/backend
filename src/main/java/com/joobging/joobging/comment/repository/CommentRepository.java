package com.joobging.joobging.comment.repository;

import com.joobging.joobging.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Override
    Optional<Comment> findById(Long aLong);

    @Query(value = "select c from Comment c where c.board.id = :id and c.parent IS NULL")
    List<Comment> findByComment_IdOrderByCreatedDateDesc(Long id);
}
