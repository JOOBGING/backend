package com.joobging.joobging.review.repository;

import com.joobging.joobging.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select h from Review h ORDER BY h.id DESC")
    List<Review> findAllDesc();

}
