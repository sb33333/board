package com.fastcampus.board.entity;

import com.fastcampus.board.dto.PostDto;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor @Getter
@Table(schema = "FASTCAMPUS")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @NotNull @NotBlank
    private String writer;
    @NotNull @NotBlank
    private String title;
    @NotNull @NotBlank
    private String content;
    private long cnt;

    @Builder
    public Board(long postId, String writer, String title, String content, long cnt) {
        this.postId = postId;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.cnt = cnt;
    }

    //Entity to DTO mapping
    public PostDto dtoMapping() {
        return PostDto.builder()
                .postId(this.postId)
                .nickName(this.writer)
                .title(this.title)
                .content(this.content)
                .build();
    }



}
