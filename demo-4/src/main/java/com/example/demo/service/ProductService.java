package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.member;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public member getProduct(member dto) {
		return repository.memberinsert(dto);
	}
	
	//자동증가
	public int getAutoProduct() {
		return repository.autoNumber();
	}
}


