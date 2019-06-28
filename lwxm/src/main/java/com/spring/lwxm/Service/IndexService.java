package com.spring.lwxm.Service;

import javax.servlet.http.HttpServletRequest;

import com.spring.lwxm.common.result.Result;

public interface IndexService {

	Result userLogin(String userName, String password, Integer type);

	Result longout(HttpServletRequest request);

}
