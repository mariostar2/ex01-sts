package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ProductService;


@Controller
public class OrderController {

	@Autowired
	private ProductService service;
	//주문등록 폼 오픈
	@RequestMapping("/member")
	public String orderForm() {
		return "memberform";
	}
	
	//주문 등록 리스트 뽑아내기
	@GetMapping("/member")
	public String autoNum(Model model ) {
		model.addAttribute("custno",service.getAutoProduct());
		return "memberform";
	}
}
