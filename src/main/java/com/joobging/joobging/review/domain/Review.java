package com.joobging.joobging.review.domain;

import com.joobging.joobging.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private String content;

    private Long star;

    // location이랑 연결

    // 멤버랑 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 생성자
    @Builder
    public Review(String content, Long star, Member member){
        this.content = content;
        this.star = star;
        this.member = member;
    }
}
