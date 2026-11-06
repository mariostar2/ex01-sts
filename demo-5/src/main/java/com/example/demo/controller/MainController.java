package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ISimpleBbsDao;
import com.example.demo.dto.SimpleBbsDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class MainController {
	

	@Autowired
	private ISimpleBbsDao dao;

	@RequestMapping("/")
	public String root() {
		System.out.println("root...........");
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String getList(Model model) {
		//Dao의 listDao()
		List<SimpleBbsDto> list  = dao.listDao();
		
		model.addAttribute("bbsList", list );
		model.addAttribute("count",dao.count());
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(Model model ,@RequestParam("id") String sid) {
		SimpleBbsDto dto =  dao.viewDao(sid);
		model.addAttribute("bbs",dto);
		return "view";	
	}
	
	@RequestMapping("/writeform")
	public String writeForm() {
		System.out.println("[Controller] writeForm........ ");
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(SimpleBbsDto bbsDto) {
		
		System.out.println("[Controller] write?........" +bbsDto.getWriter() + bbsDto.getTitle() + bbsDto.getContent());
		int result = dao.writeDao(bbsDto);
		System.out.println("[Controller] write 결과 : " + result);
		//List: dao를 거치지 않음 redirect를 해야 dao쪽에 다녀와서 조회
		return "redirect:list";
	}
	
	@RequestMapping("/update")
	public String update(SimpleBbsDto simpleBbsDto) {
		int result =dao.updateDao(simpleBbsDto);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") String id) {
		int result = dao.deleteDao(id);
		System.out.println("[Controller] delete 결과:" + id);
		return "redirect:list";
	}
	
	@RequestMapping("/writeCom")
	public String getComlist(Model model ,@RequestParam("type")String type , @RequestParam("keyword")String keyword) {
		List<SimpleBbsDto> list = dao.searchType(type, keyword);
		model.addAttribute("bbsList",list);
		model.addAttribute("count",list.size());
		return "list";
	}
	
	
	
}
