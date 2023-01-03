package com.rollingstone.BoardWeb.controller;

import com.rollingstone.BoardWeb.domain.Board;
import com.rollingstone.BoardWeb.domain.Search;
import com.rollingstone.BoardWeb.security.SecurityUser;
import com.rollingstone.BoardWeb.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController
{
    private final BoardService boardService;

    @PostMapping("/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView() {
        return "board/insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board, @AuthenticationPrincipal SecurityUser principal) {
        board.setMember(principal.getMember());
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "board/getBoard";
    }

    @RequestMapping("/getBoardList")
    public String getBoardList(Model model, Search search) {
        if(search.getSearchCondition() == null)
            search.setSearchCondition("TITLE");
        if(search.getSearchKeyword() == null)
            search.setSearchKeyword("");
        Page<Board> boardList = boardService.getBoardList(search);
        model.addAttribute("boardList", boardList);
        return "board/getBoardList";
    }
}
