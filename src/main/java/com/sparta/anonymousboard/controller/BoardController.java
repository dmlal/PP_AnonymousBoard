package com.sparta.anonymousboard.controller;

import com.sparta.anonymousboard.dto.BoardRequestDto;
import com.sparta.anonymousboard.dto.BoardResponseDto;
import com.sparta.anonymousboard.entity.Board;
import com.sparta.anonymousboard.service.BoardService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
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
    public ResponseEntity<BoardResponseDto> writeBoard(@RequestBody BoardRequestDto requestDto) {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return new ResponseEntity<>(boardService.writeBoard(requestDto), makeUTF8Header() ,HttpStatus.OK);
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

    private HttpHeaders makeUTF8Header() {
        HttpHeaders returnResHeaders = new HttpHeaders();
        returnResHeaders.add("Content-Type", "application/json;charset=UTF-8");

        return returnResHeaders;
    }

}
