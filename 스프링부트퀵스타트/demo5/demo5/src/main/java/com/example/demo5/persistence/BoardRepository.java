package com.example.demo5.persistence;

import com.example.demo5.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long>
{
    List<Board> findBoardByTitle(String searchKeyword);
    List<Board> findBoardByContentContaining(String searchKeyword);
    List<Board> findByTitleOrContentContaining(String title, String content);
    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
    Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

    @Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest1(String searchKeyword);

    @Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest2(String searchKeyword);

    @Query("SELECT b.seq, b.title, b.createDate FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
    List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);

    @Query(value="select seq, title, create_date from board where title like '%'||?1||'%' order by seq desc", nativeQuery=true)
    List<Object[]> queryAnnotationTest4(String searchKeyword);

    @Query("SELECT b FROM Board b ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest5(Pageable paging);
}
