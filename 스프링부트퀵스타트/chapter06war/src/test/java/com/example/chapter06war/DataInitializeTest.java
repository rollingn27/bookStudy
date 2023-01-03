package com.example.chapter06war;

import com.example.chapter06war.domain.Board;
import com.example.chapter06war.domain.Member;
import com.example.chapter06war.persistence.BoardRepository;
import com.example.chapter06war.persistence.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DataInitializeTest
{
    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void 테스트회원가입() {
        Member member1 = new Member();
        member1.setId("member1");
        member1.setName("둘리");
        member1.setPassword("member111");
        member1.setRole("ROLE_USER");
        memberRepo.save(member1);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setName("도우너");
        member2.setPassword("member222");
        member2.setRole("ROLE_ADMIN");
        memberRepo.save(member2);

        for(int i = 1; i <=3; i++) {
            Board board = new Board();
            board.setWriter("둘리");
            board.setTitle("둘리가 등록한 게시글 " + i);
            board.setContent("둘리가 등록한 게시글 내용 " + i);
            boardRepo.save(board);
        }

        for(int i = 1; i <=3; i++) {
            Board board = new Board();
            board.setWriter("도우너");
            board.setTitle("도우너가 등록한 게시글 " + i);
            board.setContent("도우너가 등록한 게시글 내용 " + i);
            boardRepo.save(board);
        }
    }
}
