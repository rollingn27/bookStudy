package com.rollingstone.BoardWeb.service;

import com.rollingstone.BoardWeb.domain.Board;
import com.rollingstone.BoardWeb.domain.Search;
import org.springframework.data.domain.Page;

public interface BoardService
{
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Board board);
    Board getBoard(Board board);
    Page<Board> getBoardList(Search search);
}
