package com.fastcampus.board;

import com.fastcampus.board.dto.PostDto;
import com.fastcampus.board.entity.Board;
import com.fastcampus.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    final BoardService service;
    public BoardController(BoardService service) {
        this.service = service;
        service.writeArticle(PostDto.builder()
                .nickName("sample")
                .content("sample")
                .title("sample").build());
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String createPost(@ModelAttribute("command") PostDto postDto){
        System.out.println("save " + postDto);
        service.writeArticle(postDto);
        return "redirect:/"; // 추가 후 홈 화면으로
    }


    @RequestMapping("/")
    public String ReadAllPost(Model model){
        List<PostDto> postList = service.loadArticleList();
        model.addAttribute("postList", postList);
        return "index";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updatePost(@ModelAttribute("command") PostDto postDto){
        System.out.println("update " + postDto);
        service.amendArticle(postDto.getPostId(), postDto);
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String deletePost(@PathVariable int id){
        System.out.println("삭제 " + id);
        service.deleteArticle((long) id);
        return "redirect:/";
    }

    @RequestMapping(value="/createView")
    public String ViewCreate(Model model){
        model.addAttribute("command", new PostDto());
        return "create";
    }

    @RequestMapping(value="/updateView/{id}")
    public String ViewUpdate(@PathVariable int id, Model model){
        PostDto postDto = new PostDto();
        postDto.setPostId(id);
        model.addAttribute("command",postDto);
        return "update";
    }

    @RequestMapping(value = "/articleView/{id}")
    public String articleLoad(@PathVariable int id, Model model) {
        Board entity = service.readArticle((long)id);
        PostDto postDto = entity.dtoMapping();
        model.addAttribute("command",postDto);
        return "article";
    }
}

