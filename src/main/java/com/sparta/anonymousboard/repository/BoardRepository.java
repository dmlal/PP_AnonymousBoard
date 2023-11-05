package com.sparta.anonymousboard.repository;

import com.sparta.anonymousboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository  {

    //extends JpaRepository<>
    // 상속 제네릭스 넣어주고  아래에는 쿼리스트링 넣어서 디비에서 데이터 뽑아오기
}
