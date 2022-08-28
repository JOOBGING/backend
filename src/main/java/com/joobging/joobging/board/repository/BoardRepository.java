package com.joobging.joobging.board.repository;

import com.joobging.joobging.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    @Override
    List<Board> findAll();
    void deleteById(Long id);
    Optional<Board> findById(Long id);

    @Query("select b from Board b where b.loname = :name")
    Board findByBoardName(String name);
}