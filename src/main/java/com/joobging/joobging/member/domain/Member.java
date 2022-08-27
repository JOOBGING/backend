package com.joobging.joobging.member.domain;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.review.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String name;

    private String mbti;


    @Enumerated(EnumType.STRING)
    private Authority authority;

    // review와 연결
    @OneToMany(mappedBy = "member",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>();

    // board와 연결
    @OneToMany(mappedBy = "member",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Board> boardList = new ArrayList<>();

    @Builder
    public Member(Long id, String email, String password, String name, Authority authority, String mbti,
                  List<Review> reviewList, List<Board> boardList){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.authority = authority;
        this.mbti = mbti;
        this.reviewList = reviewList;
        this.boardList = boardList;
    }
}
