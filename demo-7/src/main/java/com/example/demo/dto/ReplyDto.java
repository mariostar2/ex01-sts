package com.example.demo.dto;

import lombok.Data;

@Data
public class ReplyDto {
	private int rid;
	private int bid;
	private String pid;
	private String content;
	private String createdat;
	
}
