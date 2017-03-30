package com.ddu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddu.entity.User;
import com.ddu.service.UserService;
import com.ddu.util.ApiResult;
import com.ddu.util.ConsEnum;

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
	public @ResponseBody Object login(HttpServletRequest request, User user){
		if(StringUtils.isBlank(user.getNumber())){
			return new ApiResult<Object>(ConsEnum.Failed, "编码不能为空!");
		}
		if(StringUtils.isBlank(user.getName())){
			return new ApiResult<Object>(ConsEnum.Failed, "用户名不能为空!");
		}
		
		try {
			user = userService.queryByNameAndNumber(user.getNumber(), user.getName());
		} catch (Exception e) {
			return new ApiResult<Object>(ConsEnum.Service_Exception);
		}
		
		if(user == null){
			return new ApiResult<Object>(ConsEnum.Failed, "用户不存在，请检查编码和用户名是否正确!");
		}
		
//		Cookie[] cookies = request.getCookies();
		
//		String userId = (String)session.getAttribute("userId");
		//然后利用这个userId去查找数据库
		//加入session的方法
//		getHttpServletRequest().setAttribute(key, value);
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", user.getId());
		request.getSession().setAttribute("userId", user.getId());
		request.getSession().setAttribute("user", user);
		return new ApiResult<Object>(ConsEnum.Successed, "登录成功!");
	}
	
	@GetMapping("/loginout")
	public String loginout(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") != null)
			session.removeAttribute("userId");
		
		if(session.getAttribute("user") != null)
			session.removeAttribute("user");
		
		return "redirect:/";
	}

}
