package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Member {
	private String name;
	private String nickname;
	private Printer printer;
	
	public void print() {
		printer.print("Hello" + name + ":" + nickname);
	}
}
