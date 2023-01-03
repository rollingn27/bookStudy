package com.example.demo5;

import com.example.demo5.domain.Board;
import com.example.demo5.persistence.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class QueryAnnotationTest
{
    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void 쿼리페이징() {
        Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "seq");
        List<Board> boardList = boardRepo.queryAnnotationTest5(paging);
        printResult(boardList);
    }

    @Test
    public void 네이티브() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest4("테스트 제목 10");
        System.out.println("검색 결과");
        for(Object[] row: boardList) {
            System.out.println("---> " + Arrays.toString(row));
        }
    }

    @Test
    public void 특정칼럼() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest3("테스트 제목 10");
        System.out.println("검색 결과");
        for(Object[] row: boardList) {
            System.out.println("---> " + Arrays.toString(row));
        }
    }

     public <T> void printResult(List<T> boardList) {
        System.out.println("검색 결과");
        for(T board: boardList) {
            System.out.println("---> " + board.toString());
        }
    }

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
    public void 이름기반() {
        List<Board> boardList = boardRepo.queryAnnotationTest2("테스트 제목 10");
        printResult(boardList);
    }

    @Test
    public void 어노테이션위치기반() {
        List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목 10");
        printResult(boardList);

    }
}
