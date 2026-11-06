package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.lectureDto;

@Mapper
public interface lectureDao {
	
	public List<lectureDto>select();
	
	
}
