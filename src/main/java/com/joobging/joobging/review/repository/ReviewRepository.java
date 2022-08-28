package com.joobging.joobging.review.repository;

import com.joobging.joobging.review.domain.Review;
import com.joobging.joobging.review.dto.ReviewResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select h from Review h ORDER BY h.id DESC")
    List<Review> findAllDesc();

    @Query("select r from Review r where r.location.id = :locationId")
    List<Review> findByReview_Id(Long locationId);
}
