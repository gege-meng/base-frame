package com.ddu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddu.entity.BigSubject;
import com.ddu.service.BigSubjectService;

@Controller
@RequestMapping("bigsubject")
public class BigSubjectController {
	
	@Resource
	private BigSubjectService bigSubjectService;
	
	@GetMapping(value="/list")
	public String list(Model model){
		model.addAttribute("datas", bigSubjectService.queryAll());
		return "/bigsubject/list";
	}
	
	@GetMapping(value="/add")
	public String add(){
		return "/bigsubject/add";
	}
	
	@PostMapping(value="/add")
	public String add(BigSubject bigSubject){
		bigSubjectService.insert(bigSubject);
		return "redirect:/bigsubject/list";
	}
	
	@GetMapping(value="/start/{id}")
	public String startAnswer(@PathVariable("id") Long id){
		bigSubjectService.endAnswer(id);
		return "redirect:/bigsubject/list";
	}
	
}
