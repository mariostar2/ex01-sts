package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.BoardDto;

@Mapper
public interface BoardDao {
	public List<BoardDto>list();
	public int boardWrite(@Param("s")BoardDto dto);
	public int boardUpdate(@Param("s")BoardDto dto);
	public BoardDto view(@Param("bid")int bid);
	public int boardDelete(@Param("bid")int bid);
	
}
