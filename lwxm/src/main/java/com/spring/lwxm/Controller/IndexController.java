package com.spring.lwxm.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lwxm.Service.IndexService;
import com.spring.lwxm.Service.Impl.IndexServiceImpl;
import com.spring.lwxm.common.result.Result;

@RestController
@RequestMapping("user")
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @param type
	 * @return
	 */
	@PostMapping("login")
	public Result userLogin(String userName,String password,Integer type){
		return indexService.userLogin(userName,password,type);
		
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	@GetMapping("logout")
	public Result logout(HttpServletRequest request){
		return indexService.longout(request);
	}
	
}
