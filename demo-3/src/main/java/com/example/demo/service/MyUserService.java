package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MyUserDto;
import com.example.demo.repository.MyUserRepository;

@Service
public class MyUserService {
	
	@Autowired
	private MyUserRepository repository;
	//myuser 테이블에서 userid로 조회를 하기
	//컨트롤러에서 userid를 파라미터로 받아서.
	//그 파라미터를 서비스의 getUser() 메소드에 전달하면 
	//getUser()는 그 userid를 리파지토리(다오)에 전달한다.
	public  MyUserDto getUser(String userid) {
		return 	repository.SelectOne(userid);
	}
	
	//전체 조회 요청을 리포지토리에 전달하여 받기
	public List<MyUserDto> getUsers(){
		return repository.getUserList();
	}
	
	//유저 수정
	public int updateUser(String userid , String username) {
		return repository.userUpdate(userid,username);
	}
	//유저 삭제
	public int deleteUser(String userid) {
		return repository.delete(userid);
		
	}
	
}
