package com.ddu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ddu.entity.User;
import com.ddu.service.UserService;

public class BaseController {

	@Resource
	protected UserService userService;
	
	protected User getCurrentUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long userId = (Long)session.getAttribute("userId");
		
		return (userId == null) ? null : userService.queryOne(userId);
	}
	
}
