package com.sparta.anonymousboard.entity;

import com.sparta.anonymousboard.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "board")
@NoArgsConstructor
public class Board extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    private String userName;
    private String title;
    private String content;
    private String password;

    public Board(BoardRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
