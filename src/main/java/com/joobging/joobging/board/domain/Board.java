package com.joobging.joobging.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joobging.joobging.member.domain.Member;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table
@Data
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    private String map;

    // 멤버와 연결
    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

}

