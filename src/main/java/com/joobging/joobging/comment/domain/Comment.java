package com.joobging.joobging.comment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "comment")
public class Comment {
    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private String name;
    private String content;
    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Long id;

    @Builder
    public Comment(String name, String content, Long id) {
        this.name = name;
        this.content = content;
        this.id = id;
    }
}
