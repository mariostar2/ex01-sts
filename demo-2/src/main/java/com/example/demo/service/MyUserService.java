package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MyUserDao;
import com.example.demo.dto.MyUser;

@Service
public class MyUserService {
	@Autowired
	private MyUserDao muDao;
	
	public int regist(MyUser dto) {
		System.out.println("[서비스:] regist 실행...." + dto );
		
		int result = muDao.insert(dto);
		return result;
		
	}
	
}
