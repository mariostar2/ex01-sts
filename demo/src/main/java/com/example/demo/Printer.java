package com.example.demo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Printer {
	public void print(String s) {
		System.out.println("내용:" + s);
	}

}
