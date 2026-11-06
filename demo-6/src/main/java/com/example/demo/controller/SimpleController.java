package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.SimpleDao;
import com.example.demo.dto.SimpleDto;

@Controller
public class SimpleController {
	@Autowired
	private SimpleDao dao;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:list";
	}
	
	//jsp list 
	@RequestMapping("/list")
	public String getList(Model model) {
		List<SimpleDto>list = dao.list();
		model.addAttribute("list",dao.list());
		return "list";
	}
	
	@RequestMapping("/writeform")
	public String writeForm() {
		return"writeForm";
	}
	
	@RequestMapping("/write")
	public String write(SimpleDto dto) {
	    dao.write(dto);
		return "redirect:list";
	}
	
	@RequestMapping("/updateform")
	public String updateForm(Model model ,@RequestParam("id") String id) {
		model.addAttribute("s",dao.view(id));
		return "update";
	}
	
	@RequestMapping("/update")
	public String update(SimpleDto dto) {
		int result = dao.update(dto);
		return "redirect:list";			
	}

}