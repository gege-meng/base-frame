package com.ddu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddu.entity.User;
import com.ddu.service.UserService;

@Controller
@RequestMapping
public class IndexController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private UserService userService;
	
	@GetMapping
	public String index(HttpServletRequest request){
		return "index";
	}
	
	@PostMapping("/login")
	public @ResponseBody Object login(HttpServletRequest request, Model model, User user){
		if(StringUtils.isBlank(user.getNumber())){
			model.addAttribute("result", "编码不能为空!");
			return false;
		}
		if(StringUtils.isBlank(user.getName())){
			model.addAttribute("result", "用户名不能为空!");
			return false;
		}
		
		user = userService.queryByNameAndNumber(user.getNumber(), user.getName());
		if(user == null){
			model.addAttribute("result", "用户不存在，请检查编码和用户名是否正确!");
			return false;
		}
		
//		Cookie[] cookies = request.getCookies();
		
//		String userId = (String)session.getAttribute("userId");
		//然后利用这个userId去查找数据库
		//加入session的方法
//		getHttpServletRequest().setAttribute(key, value);
		
		request.getSession().setAttribute("userId", user.getId());
		model.addAttribute("result", "登录成功!");
		return true;
	}

}
