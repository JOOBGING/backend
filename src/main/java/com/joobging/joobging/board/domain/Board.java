package com.joobging.joobging.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joobging.joobging.comment.domain.Comment;
import com.joobging.joobging.member.domain.Member;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    // 이거 뭐더라?
    private String map;

    private String locationName;

    // 멤버와 연결
    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    // 댓글과 연결
    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    // 연관관계 메소드
    public void addComment(Comment comment){
        commentList.add(comment);
    }

    public void update(String title, String content, String map, String locationName){
        this.title = title;
        this.content = content;
        this.map = map;
        this.locationName = locationName;
    }
}

