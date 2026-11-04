package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.MyUserDto;

@Repository
public class MyUserRepository {
	@Autowired
	private JdbcTemplate jt;
	
	
	//서비스가 전달해준 userid 파라미터를 가지고,
	//데이터베이스에 쿼리를 보내 그 userid와 일치하는 user 정보를 
	//데이터베이스로 부터 받는다.
	//그리고 받은 데이터를 서비스로 보내준다.(돌려준다)
	public MyUserDto SelectOne(String userid) {
		//db 접속 -- >쿼리 실행 -- > 결과받기 -- > 결과 전달(서비스) 
	
		String sql  = "SELECT * FROM myuser WHERE userid = '" + userid + "'" ;
		System.out.println("userid 데이터 [" + userid + "]");
		MyUserDto dto = jt.queryForObject(sql , new BeanPropertyRowMapper<>(MyUserDto.class),userid);
		return dto;
	}
	
	//전체 user 정보 조회
	public List<MyUserDto> getUserList() {
		String sql = "SELECT * FROM myuser";
		List<MyUserDto> userList = jt.query(sql, new BeanPropertyRowMapper<>(MyUserDto.class));
		return userList;
	}
	
	//유저 업데이트
	public int userUpdate(String userid, String username) {
		String sql = "UPDATE myuser SET username = ? WHERE userid = ?";  
		return jt.update(sql, username, userid);
	}

	//유저 삭제
	public int delete(String userid) {
		String sql ="DELETE FROM  myuser WHERE username = ?";
		return jt.update(sql,userid);
	}

	

	

	
	

}
