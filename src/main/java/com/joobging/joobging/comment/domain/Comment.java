package com.joobging.joobging.comment.domain;

import com.joobging.joobging.board.domain.Board;
import com.joobging.joobging.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    // 멤버랑 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // board랑 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    // 부모 댓글
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    // 자식 댓글
    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> children = new ArrayList<>();

    @Builder
    public Comment(Long id, String content, Member member, Board board, Comment parent){
        this.id = id;
        this.content = content;
        this.member = member;
        this.board = board;
        this.parent = parent;
    }

    // 연관관계 메소드
    public void confirmMember(Member member){
        this.member = member;
        member.addComment(this);
    }

    public void confirmBoard(Board board){
        this.board = board;
        board.addComment(this);
    }

    public void confirmParent(Comment parent){
        this.parent = parent;
        parent.addChild(this);
    }

    public void addChild(Comment comment){
        children.add(comment);
    }
}
