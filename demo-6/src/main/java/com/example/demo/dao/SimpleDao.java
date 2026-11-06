package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jspecify.annotations.Nullable;

import com.example.demo.dto.SimpleDto;

@Mapper	
public interface SimpleDao {
	
	public List<SimpleDto>list();
	public int insert(String writer, String title ,String content);
	public int write(@Param("s")SimpleDto dto);
	public int update(@Param("s")SimpleDto dto);
	//수정페이지용 뷰
	public SimpleDto view(@Param("id")String id);
	
}
