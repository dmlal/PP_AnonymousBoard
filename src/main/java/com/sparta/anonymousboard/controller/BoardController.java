package com.sparta.anonymousboard.controller;

import com.sparta.anonymousboard.entity.Board;
import com.sparta.anonymousboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @GetMapping("/post")
    public String writeBoardForm(){
        return "writeBoard";
    }

    @PostMapping("/postcheck")
    public String writtenBoardCheck(Board board){
        boardService.write(board);
        return "";
    }
}
