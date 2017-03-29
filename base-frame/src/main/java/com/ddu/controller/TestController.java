package com.ddu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ddu.service.UserService;

@Controller
public class TestController {
	
	@Resource
	private UserService userService;
	
	/*@Resource
	private Student student;
	
	@GetMapping("/hello")
	public @ResponseBody Student sayHello(){
		return student;
	}*/
	
	@GetMapping("/say")
	public String sayhello(ModelMap model){
		model.addAttribute("datas", userService.queryAll());
		return "/hello";
	}
	
}
