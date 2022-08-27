package com.joobging.joobging.location.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joobging.joobging.review.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "location")
public class Location {
    private String name;
    private Double latitude;//위도
    private Double longitude;//경도
    @ManyToOne
    @JoinColumn(name = "review_id")
    @JsonIgnore
    private Review review;

    @Builder
    public Location(String name, Double latitude, Double longitude, Long star) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
