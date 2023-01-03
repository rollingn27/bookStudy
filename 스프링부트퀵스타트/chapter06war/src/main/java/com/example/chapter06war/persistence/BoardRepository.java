package com.example.chapter06war.persistence;

import com.example.chapter06war.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long>
{
}
