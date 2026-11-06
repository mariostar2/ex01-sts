package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Bbs")
public class SimpleBbsDto {
	private int id;
	private String writer;
	private String title;
	private String content;
}
