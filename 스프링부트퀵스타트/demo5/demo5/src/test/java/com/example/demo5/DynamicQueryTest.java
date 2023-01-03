package com.example.demo5;

import com.example.demo5.domain.Board;
import com.example.demo5.domain.QBoard;
import com.example.demo5.persistence.DynamicBoardRepository;
import com.querydsl.core.BooleanBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DynamicQueryTest
{
    @Autowired
    private DynamicBoardRepository boardRepo;

    @BeforeEach
    public void 데이터사전준비() {
        for(int i = 1; i <= 200; i++) {
            Board board = new Board();
            board.setTitle("테스트 제목 " + i);
            board.setContent("테스트 내용 " + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardRepo.save(board);
        }
    }

    @Test
    public void testDynamicQuery() {
        String searchCondition = "TITLE";
        String searchKeyword = "테스트 제목 10";

        BooleanBuilder builder = new BooleanBuilder();
        QBoard qboard = QBoard.board;

        if(searchCondition.equals("TITLE")) {
            builder.and(qboard.title.like("%" + searchKeyword + "%"));
        } else if(searchCondition.equals("CONTENT")) {
            builder.and(qboard.content.like("%" + searchKeyword + "%"));
        }

        Pageable paging = PageRequest.of(0, 5);
        Page<Board> boardList = boardRepo.findAll(builder, paging);
        List<Board> boardList1 = boardList.getContent();
        printResult(boardList1);

    }

    public <T> void printResult(List<T> boardList) {
        System.out.println("검색 결과");
        for(T board: boardList) {
            System.out.println("---> " + board.toString());
        }
    }
}
