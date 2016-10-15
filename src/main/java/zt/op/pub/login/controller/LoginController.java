package zt.op.pub.login.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zt.op.common.dto.ResultDTO;
import zt.op.pub.login.service.LoginService;

@Controller
@RequestMapping("/pub/login")
public class LoginController {
	
	@Resource
	private LoginService loginService;
	
	
	@RequestMapping("/index")
	public void index(){
		
		
	}
	
}
