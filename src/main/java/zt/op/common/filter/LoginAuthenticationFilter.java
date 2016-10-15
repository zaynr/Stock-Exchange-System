package zt.op.common.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hundsun.jresplus.exception.BaseException;

import zt.op.common.dto.ResultDTO;
import zt.op.common.dto.TokenQueryRequest;
import zt.op.pub.login.service.LoginService;

public class LoginAuthenticationFilter implements Filter{
	
	@Resource
	private LoginService loginService;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			
		int capitalAccountId = Integer.valueOf(request.getParameter("capitalAccountId"));
		String userToken = request.getParameter("userToken");
		
		TokenQueryRequest req = new TokenQueryRequest();
		req.setFuncId(810201);
		req.setCapitalAccountId(capitalAccountId);
		req.setUserToken(userToken);
		
		try {
			ResultDTO resultDTO = loginService.judgeToken(req);
			chain.doFilter(request, response);
			return;
		} catch (BaseException e) {
			((HttpServletResponse) response).sendRedirect("/pub/login/index.htm");
		}
						
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
