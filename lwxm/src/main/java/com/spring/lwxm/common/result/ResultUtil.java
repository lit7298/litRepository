package com.spring.lwxm.common.result;

import org.springframework.validation.BindingResult;

import com.spring.lwxm.common.util.PageBean;




/**
 * 2018-01-21 13:39
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    
    
    public static Result success(PageBean pageBean) {
    	Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(pageBean.getList());
        result.setCount(pageBean.getTotal());
        return result;
    }

    public static Result success() {
    	Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(null);
        result.setCount(0l);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    
    public static Result error(BindingResult bindingResult){
    	StringBuffer sb = new StringBuffer();
    	Result result = new Result();
    	result.setCode(400);
    	String msg;
    	for(int i=0;i<bindingResult.getAllErrors().size();i++){
    		sb.append(bindingResult.getFieldErrors().get(i).getDefaultMessage()).append(",");
    	}
        result.setMsg(sb.toString());
        return result;
    }
}
