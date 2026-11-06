package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.ReplyDao;
import com.example.demo.dto.BoardDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    private BoardDao dao;

    @Autowired
    private ReplyDao repDao;
    
    @RequestMapping("/")
    public String home() {
        return "redirect:/board/list";
    }

    // 목록
    @RequestMapping("/board/list")
    public String boardList(Model model) {
    	model.addAttribute("list", dao.list());
        model.addAttribute("replyList", repDao.replyList());
        return "board/list";	
    }

    // 상세
    @RequestMapping("/board/view")
    public String viewPage(@RequestParam("bid") int bid, Model model) {
        model.addAttribute("s", dao.view(bid));
        return "board/view";
    }

    // 글쓰기 폼
    @RequestMapping("/board/writeform")
    public String writeForm(HttpSession session) {
    	if(session.getAttribute("userid") == null) {
    		return "redirect:/user/login";	
    	}
        return "board/writeForm";
    }

    // 작성
    @RequestMapping("/board/write")
    public String write(BoardDto dto, HttpSession session) {
        String userid = (String) session.getAttribute("userid");
    	if(userid == null) {
        	return "redirect:/user/login";
        }
    	dto.setPid(userid);
    	dao.boardWrite(dto);
        return "redirect:list";
    }

    // 수정
    @RequestMapping("/board/update")
    public String update(BoardDto dto,HttpSession session) {
        if(session.getAttribute("userid") == null) {
        	return "redirect:/user/login";
        }
    	dao.boardUpdate(dto);
        return "redirect:list";
    }

    // 삭제
    @RequestMapping("/board/delete")
    public String delete(@RequestParam("bid") int bid ,HttpSession session) {
        if(session.getAttribute("userid") == null) {
        	return "redirect:/user/login";
        }
    	dao.boardDelete(bid);
        return "redirect:list";
    }
    
  
}