package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.ReplyDao;
import com.example.demo.dto.ReplyDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReplyController {	

	@Autowired
	private ReplyDao repDao;
	
	//댓글 리스트용 컨트롤러(AJAX)
	@RequestMapping("/reply/list")
	@ResponseBody
	public List<ReplyDto> list() {
	    return repDao.replyList();
	}
	
	//댓글 작성용 컨트롤러 
	@RequestMapping("/reply/replyWrite")
	public String replyWrite(ReplyDto dto, HttpSession session) {
		//세션처리 
	    session.setAttribute("id", session);
		repDao.replyWrite(dto);
		return "redirect:/board/list";
	}
	
	//댓글 작성용 컨트롤러(Ajax)
	@RequestMapping("/reply/create")
	@ResponseBody
	public String replyCreate(ReplyDto dto, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		if(userid ==null) {
			return "login";
		}
		dto.setPid(userid);
		repDao.replyWrite(dto);
		return "Okay";
	}
	
	//댓글 수정용 컨트롤러
	@RequestMapping("/reply/replyUpdate")
	public String replyUpdate(ReplyDto dto) {
		repDao.replyUpdate(dto);
		return "redirect:/board/list";
	}
	
	//댓글 수정용 컨트롤러(Ajax)
	@RequestMapping("/reply/update")
	@ResponseBody
	public String update(ReplyDto dto, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		if(userid == null) {
			return "login";
		}
		dto.setPid(userid);
		
		int result = repDao.replyUpdate(dto);
		if(result > 0 ) {
			return "Okay";
		}
		return "fail";
		
	}
	//댓글 삭제용 컨트롤러
	@RequestMapping("/reply/replyDelete")
	public String replyDelete(ReplyDto dto, HttpSession session) {
	    String userid = (String) session.getAttribute("userid");
	    if (userid == null) {
	        return "redirect:/user/login";
	    }
	    dto.setPid(userid);
	    repDao.replyDelete(dto);
	    return "redirect:/board/list";
	}
	
	//댓글 삭제용 컨트롤러 (ajax)
	@RequestMapping("/reply/delete")
	@ResponseBody
	public String delete(ReplyDto dto, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		if(userid == null) {
			return "login";
		}
		dto.setPid(userid);
		
		int result = repDao.replyDelete(dto);
		if(result > 0 ) {
			return "Okay";
		}
		return "fail";
		
	}
	
}
