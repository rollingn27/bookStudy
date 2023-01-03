package com.example.chapter06war.controller;

import com.example.chapter06war.domain.Board;
import com.example.chapter06war.domain.Member;
import com.example.chapter06war.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SessionAttributes("member")
@Controller
@RequiredArgsConstructor
public class BoardController
{
    private final BoardService boardService;

    @ModelAttribute("member")
    public Member setMember() {
        return new Member();
    }

    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("greeting", "Hello 타임리프.^^");
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
        if(member.getId() == null) {
            return "redirect:login";
        }
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute("member") Member member, Board board) {

        if(member.getId() == null) {
            return "redirect:login";
        }
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(@ModelAttribute("member") Member member, Board board) {

        if(member.getId() == null) {
            return "redirect:login";
        }
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
        if(member.getId() == null) {
            return "redirect:login";
        }
        model.addAttribute("board", boardService.getBoard(board));
        return "getBoard";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView(@ModelAttribute("member") Member member) {
        if(member.getId() == null) {
            return "redirect:login";
        }
        return "insertBoard";
    }

    @RequestMapping("/getBoardList")
    public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {

        if(member.getId() == null) {
            return "redirect:login";
        }

        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }
}
