package com.ddu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddu.entity.User;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@ModelAttribute
	public void init(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException{
		User user = getCurrentUser(request);
		if(user == null){
			logger.info("用户未登录!");
			response.sendRedirect("/");
		}
		model.addAttribute("user", user);
	}
	
	@GetMapping(value="/list")
	public String list(Model model){
		model.addAttribute("datas", userService.queryAll());
		return "/user/list";
	}
	
	@GetMapping(value="/add")
	public String add(){
		return "/user/add";
	}
	
	@PostMapping(value="/add")
	public String add(User user){
		logger.info("user add {}", user);
		userService.insert(user);
		return "redirect:/user/list";
	}
	
}
