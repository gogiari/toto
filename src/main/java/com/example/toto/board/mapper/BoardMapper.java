package com.example.toto.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.toto.board.vo.BoardVo;

@Repository
@Mapper
public interface BoardMapper {

    List<BoardVo> getBoardList();

}
