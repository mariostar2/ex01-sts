package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.ReplyDto;

@Mapper
public interface ReplyDao {
	//board에 bid값 받아서 만들가
	public List<ReplyDto>replyList();
	public int replyWrite(@Param("reply")ReplyDto dto);
	public int replyUpdate(@Param("reply")ReplyDto dto);
	public int replyDelete(@Param("reply")ReplyDto dto);
}
