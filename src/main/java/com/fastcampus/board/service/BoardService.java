package com.fastcampus.board.service;

import com.fastcampus.board.dto.PostDto;
import com.fastcampus.board.entity.Board;
import com.fastcampus.board.repository.MyCrudRepository;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private final MyCrudRepository repository;
    public BoardService(MyCrudRepository repository) {
        this.repository = repository;
    }

    public void writeArticle (PostDto dto) { //게시글 추가
        Board entity = Board.builder()
                .writer(dto.getNickName())
                .title(dto.getTitle())
                .content(dto.getContent()).build();
            repository.save(entity);
    }

    public List<PostDto> loadArticleList() {  //게시글 목록 불러오기
        List<PostDto> result = new ArrayList<>();
        repository.findAll().forEach((entity) -> {result.add(entity.dtoMapping());});
        return result;
    }

    public void deleteArticle(Long id) {    //게시글 삭제
        repository.deleteById(id);
    }

    public Board readArticle(Long id) { //게시글 불러오기
        Board entity = repository.findById(id).get();
        Board amendEntity = Board.builder()
                .postId(entity.getPostId())
                .title(entity.getTitle())
                .writer(entity.getWriter())
                .content(entity.getContent())
                .cnt(entity.getCnt() + 1)
                .build();
        repository.save(amendEntity);
        return amendEntity;
    }

    public void amendArticle(Long id, PostDto dto) {
        Board entity = repository.findById(id).get();
        Board amendEntity = Board.builder()
                .postId(id)
                .title(dto.getTitle())
                .writer(dto.getNickName())
                .content(dto.getContent())
                .cnt(entity.getCnt() + 1)
                .build();
        repository.save(amendEntity);
    }

}
