package com.joobging.joobging.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table
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

    @Builder
    public Member(Long id, String email, String password, String name, Authority authority, String mbti){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.authority = authority;
        this.mbti = mbti;
    }
}
