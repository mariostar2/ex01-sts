package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.bean.Member;
import com.example.demo.bean.PrintA;

@Configuration
public class BeanConfig {
	
	@Bean
	public Member member1() {
		Member member =new Member();
		member.setName("홍길동");
		member.setNickname("도사");
		member.setPrinter(new PrintA());
		
		return null;
	
	}
}
