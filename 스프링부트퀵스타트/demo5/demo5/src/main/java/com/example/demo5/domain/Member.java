package com.example.demo5.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString(exclude = "boardList")
public class Member
{
    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String password;
    private String name;
    private String role;

    @OneToMany(mappedBy="member", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<Board>();
}
