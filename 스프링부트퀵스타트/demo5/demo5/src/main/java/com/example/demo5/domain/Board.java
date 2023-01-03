package com.example.demo5.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ToString(exclude="member")
public class Board
{
    @Id @GeneratedValue
    private Long seq;
    private String title;

    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    private Long cnt;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID", nullable = false)
    private Member member;

    public void setMember(Member member) {
        this.member = member;
        member.getBoardList().add(this);
    }
}
