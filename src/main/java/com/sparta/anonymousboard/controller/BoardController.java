package com.sparta.anonymousboard.controller;

import com.sparta.anonymousboard.dto.BoardRequestDto;
import com.sparta.anonymousboard.dto.BoardResponseDto;
import com.sparta.anonymousboard.entity.Board;
import com.sparta.anonymousboard.service.BoardService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/post")
    public BoardResponseDto writeBoard(@RequestBody BoardRequestDto requestDto) {

        return boardService.writeBoard(requestDto);
    }

    @GetMapping("/posts")
    public List<BoardResponseDto> getBoard() {
        return boardService.getBoard();
    }

    @PutMapping("/post/{index}")
    public Integer updateBoard(@PathVariable Integer index, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(index, requestDto);
    }

    @DeleteMapping("/post/{index}")
    public Integer deleteBoard(@PathVariable Integer index) {
        return boardService.deleteBoard(index);
    }
}
