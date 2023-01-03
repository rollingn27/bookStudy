package com.example.demo5;

import com.example.demo5.domain.Board;
import com.example.demo5.persistence.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardRepositoryTest
{
    @Autowired
    private BoardRepository boardRepo;

    public void printResult(List<Board> boardList) {
        System.out.println("검색 결과");
        for(Board board: boardList) {
            System.out.println("--->" + board);
        }
    }

    @Test
    public void 검색페이징정렬() {
        Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
        Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
        System.out.println("PAGE SIZE : " + pageInfo.getSize());
        System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
        System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
        System.out.println("NEXT : " + pageInfo.nextPageable());
        List<Board> boardList = pageInfo.getContent();
        printResult(boardList);
    }

    @Test
    public void 검색내림차순() {
        List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
        printResult(boardList);
    }

    @Test
    public void 제목일치내용포함() {
        List<Board> boardList = boardRepo.findByTitleOrContentContaining("테스트 제목 27", "17");
        printResult(boardList);
    }

    @Test
    public void 검색어포함검색() {
        List<Board> boardList = boardRepo.findBoardByContentContaining("17");
        System.out.println("검색 결과");
        for(Board board: boardList) {
            System.out.println("--->" + board);
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
    public void 제목검색() {
        List<Board> boardList = boardRepo.findBoardByTitle("테스트 제목 1");
        System.out.println("검색 결과");
        for(Board board: boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void 삭제() {
        boardRepo.deleteById(1L);
    }

    @Test
    public void 수정() {
        System.out.println("=== 1번 게시글 조회 ===");
        Board board = boardRepo.findById(1L).get();

        System.out.println("===1번 게시글 제목 수정 ===");
        board.setTitle("제목을 수정했습니다.");
        boardRepo.save(board);
    }


    @Test
    public void testGetBoard() {
        Board board = boardRepo.findById(1L).get();
        System.out.println(board);
    }

    @Test
    public void testInsertBoard() {
        Board board = new Board();
        board.setTitle("첫 번째 게시글");
        board.setContent("잘 등록되나요?");
        board.setCreateDate(new Date());
        board.setCnt(0L);

        boardRepo.save(board);
    }
}
