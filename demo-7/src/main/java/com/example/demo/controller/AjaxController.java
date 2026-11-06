package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CommandObj;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	
	@RequestMapping("/")
	public String ajaxIndex() {
		return"ajaxIndex";
	}
	
	@RequestMapping("/test0")
	public@ResponseBody String noparam() {
		System.out.println("[AjaxController]noparam....");
		return "{\"writer\": \"홍길동\", \"message\": 23}";
	}
	
	@RequestMapping("/test1")
	public@ResponseBody CommandObj param(@RequestParam("writer")String writer, @RequestParam("message")String message) {
		System.out.println("[AjaxController] param..." + writer +":" + message );
		CommandObj obj =  new CommandObj();
		obj.setWriter(writer);
		obj.setMessage(message);
		return obj;
	}
	
	@RequestMapping("/test2")
	public@ResponseBody CommandObj formData(CommandObj obj) {
		System.out.println("[AjaxController]formData...." + obj);
		return obj;
	}
	
	@PostMapping("/test3")
	public@ResponseBody CommandObj jsonData(@RequestBody CommandObj obj) {
			System.out.println("[AjaxController] jsonData...." + obj);
		return obj;
	}
	
	
}
