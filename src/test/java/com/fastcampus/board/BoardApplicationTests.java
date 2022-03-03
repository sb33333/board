package com.fastcampus.board;

import com.fastcampus.board.entity.Board;
import com.fastcampus.board.repository.MyCrudRepository;
import com.fastcampus.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardApplicationTests {

    @Autowired
    private BoardService service;



    @Test
    public void writeBoard() {
    }

    @Test
    public void deleteBoard() {

    }

    @Test
    public void findAllBoard() {
    }


}
