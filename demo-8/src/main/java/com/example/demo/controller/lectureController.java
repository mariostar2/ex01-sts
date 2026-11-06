package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.lectureDao;
import com.example.demo.dto.lectureDto;

@Controller
@RequestMapping("/index")
public class lectureController {
	
	@Autowired
	private lectureDao dao;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/test01")
	public @ResponseBody  List<lectureDto> list(){
		List<lectureDto> list = dao.select();
		System.out.println("[local Server]..." + list);
		return list;
	}
}
