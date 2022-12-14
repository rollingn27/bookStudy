package com.rollingstone.BoardWeb.domain;

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
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean enabled;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Board> boardList = new ArrayList<Board>();
}
