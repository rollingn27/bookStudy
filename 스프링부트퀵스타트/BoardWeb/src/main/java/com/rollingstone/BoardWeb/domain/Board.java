package com.rollingstone.BoardWeb.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ToString(exclude = "member")
public class Board
{
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createDate = new Date();
    @Column(updatable = false)
    private Long cnt = 0L;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID", nullable = false, updatable = false)
    private Member member;

    public void setMember(Member member) {
        this.member = member;
        member.getBoardList().add(this);
    }
}
