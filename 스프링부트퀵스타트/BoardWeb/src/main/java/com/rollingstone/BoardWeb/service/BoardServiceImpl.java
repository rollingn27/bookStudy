package com.rollingstone.BoardWeb.service;

import com.querydsl.core.BooleanBuilder;
import com.rollingstone.BoardWeb.domain.Board;
import com.rollingstone.BoardWeb.domain.QBoard;
import com.rollingstone.BoardWeb.domain.Search;
import com.rollingstone.BoardWeb.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService
{
    private final BoardRepository boardRepo;

    @Override
    public void insertBoard(Board board)
    {
        boardRepo.save(board);
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

    @Override
    public Board getBoard(Board board)
    {
        return boardRepo.findById(board.getSeq()).get();
    }

    @Override
    public Page<Board> getBoardList(Search search)
    {
        BooleanBuilder builder = new BooleanBuilder();
        QBoard qboard = QBoard.board;

        if(search.getSearchCondition().equals("TITLE")) {
            builder.and(qboard.title.like("%" + search.getSearchKeyword() + "%"));
        }
        else if(search.getSearchCondition().equals("CONTENT")) {
            builder.and(qboard.content.like("%" + search.getSearchKeyword() + "%"));
        }

        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
        return boardRepo.findAll(builder, pageable);
    }
}
