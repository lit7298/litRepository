package com.spring.lwxm.common.util;

import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class WebHandler implements HandlerInterceptor{
	
	@Value("${token.timeout}")
	private Integer timeout;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate; 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//请求头和缓存中都有token，那么允许访问
		if(request.getHeader("Authorization")!=null && redisTemplate.hasKey(request.getHeader("Authorization"))) {
			//允许访问之前，让token重新计时,其中(k,v)还是以前的，但是redis有效时间重新设置
			redisTemplate.opsForValue().set(request.getHeader("Authorization"), redisTemplate.opsForValue().get(request.getHeader("Authorization")), timeout, TimeUnit.SECONDS);
			return true;
		}
		//否则，不允许访问
		response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        OutputStream out=response.getOutputStream();
        String str="{";
        		str+= " \"code\": 300,";
        		 str+=" \"msg\": \"token过期或没有token值\",";
        		 str+=" \"data\": null";
        		str+="}";
        out.write(str.getBytes());
        out.close();
        return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}	
}


