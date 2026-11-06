package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.SimpleBbsDto;

@Mapper

public interface ISimpleBbsDao {
	@Select("SELECT * FROM simple_bbs ORDER BY id DESC")
	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(@Param("_id") String id );
	public int writeDao(String writer,String title,String content);
	//mapper 클래스에 전달 
	public int writeDao(@Param("dto")SimpleBbsDto dto);
	public int updateDao(@Param("dto")  SimpleBbsDto  simpleBbsDto); 
	public int deleteDao(@Param("_id")String id);
	public List<SimpleBbsDto> searchType (@Param("type") String type ,@Param("keyword") String keyword);//검색 
	public int count();
}
