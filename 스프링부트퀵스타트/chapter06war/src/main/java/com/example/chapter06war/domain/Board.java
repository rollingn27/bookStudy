package com.example.chapter06war.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Board
{
    @Id @GeneratedValue
    private Long seq;
    private String title;
    @Column(updatable=false)
    private String writer;
    private String content;
    @Column(insertable = false, updatable = false, columnDefinition = "date default current_timestamp")
    private Date createDate;
    @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
    private Long cnt;
}
