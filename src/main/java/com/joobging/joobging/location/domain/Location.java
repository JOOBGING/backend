package com.joobging.joobging.location.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joobging.joobging.review.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "location")
public class Location {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    private String name;
    private Double latitude;//위도
    private Double longitude;//경도


    @OneToMany(mappedBy = "location",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>();

    @Builder
    public Location(String name, Double latitude, Double longitude, Long star, List<Review> reviewList) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.reviewList = reviewList;
    }
}
