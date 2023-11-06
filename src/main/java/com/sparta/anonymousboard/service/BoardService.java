package com.sparta.anonymousboard.service;

import com.sparta.anonymousboard.dto.BoardRequestDto;
import com.sparta.anonymousboard.dto.BoardResponseDto;
import com.sparta.anonymousboard.entity.Board;
import com.sparta.anonymousboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public BoardResponseDto writeBoard(BoardRequestDto requestDto){
        Board board = new Board(requestDto);

        Board saveBoard = boardRepository.save(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return boardResponseDto;
    }

    public List<BoardResponseDto> getBoard() {
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    @Transactional
    public Integer updateBoard(Integer index, BoardRequestDto requestDto) {
        Board board = findBoard(index);
        board.update(requestDto);
        return index;
    }

    public Integer deleteBoard(Integer index){
        Board board = findBoard(index);
        boardRepository.delete(board);
        return index;
    }

    private Board findBoard(Integer index) {
        return boardRepository.findById(index).orElseThrow( () ->
                new IllegalArgumentException(("선택한 글은 존재하지 않습니다"))
                );
    }
}
