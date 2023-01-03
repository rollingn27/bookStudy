package com.example.chapter06.controller;

import com.example.chapter06.domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController
{
    @RequestMapping("/getBoardList")
    public String getBoardList(Model model) {
        System.out.println("테스트");
        List<Board> boardList = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            Board board = new Board();
            board.setSeq(new Long(i));
            board.setTitle("게시판 프로그램 테스트");
            board.setWriter("도우너");
            board.setContent("게시판 프로그램 테스트입니다...");
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardList.add(board);
        }
        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }
}
