package com.example.chapter06war.service;

import com.example.chapter06war.domain.Board;
import com.example.chapter06war.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService
{
    private final BoardRepository boardRepo;

    @Override
    public List<Board> getBoardList(Board board)
    {
        return (List<Board>) boardRepo.findAll();
    }

    @Override
    public void insertBoard(Board board)
    {
        boardRepo.save(board);
    }

    @Override
    public Board getBoard(Board board)
    {
        return boardRepo.findById(board.getSeq()).get();
    }

    @Override
    public void updateBoard(Board board)
    {
        Board findBoard = boardRepo.findById(board.getSeq()).get();

        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepo.save(findBoard);
    }

    @Override
    public void deleteBoard(Board board)
    {
        boardRepo.deleteById(board.getSeq());
    }
}
