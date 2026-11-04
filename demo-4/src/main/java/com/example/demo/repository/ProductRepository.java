package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.member;

@Repository
public class ProductRepository {

	@Autowired
	private JdbcTemplate jc;
	
	//홈쇼핑 회원 번호 자동증가 **
	public int autoNumber(){
		String sql  ="SELECT * NVL(MAX(CUSTNO)0) +1 FROM member_tbl02";
		return jc.queryForObject(sql, Integer.class);
	}
	//홈쇼핑 회원 등록
	public  member memberinsert(member dto) {
		String sql = "INSERT INTO member_tbl02  "
				+ "VALUES(?,?,?,?,?,?,?)";
		jc.update(sql,dto.getCustno(),dto.getCustname(),dto.getPhone(), dto.getAddress(),dto.getJoindate(),dto.getGrade(),dto.getCity());
		return dto;
	}	
	
	//주문 목록조회
	
	//점포별주문현황

	//제품코드조회
	
	//집으로~
	
}
