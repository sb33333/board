package com.fastcampus.board.repository;

import com.fastcampus.board.entity.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyCrudRepository extends CrudRepository<Board, Long> {

}
