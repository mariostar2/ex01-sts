package com.example.demo.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int bid;
	private String pid;
	private String title;
	private String content;
	private String createdat;
	private String updatedat;
}
