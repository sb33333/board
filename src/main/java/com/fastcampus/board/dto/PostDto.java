package com.fastcampus.board.dto;

import com.fastcampus.board.entity.Board;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    // PostDto는 JSP 화면과 Spring 서버가 주고받는 객체입니다.
    // PostDto를 수정하시기보다는 Post 클래스를 만들어 사용하기를 권장합니다.
    private long postId;
    @NotEmpty
    private String nickName;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;


    //DTO to Entity Mapping
    public Board entityMapping() {
        return Board.builder()
                    .postId(this.postId)
                    .writer(this.nickName)
                    .title(this.title)
                    .content(this.content)
                    .build();

    }

}
