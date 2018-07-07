package com.myjsp.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ¹ýÂË×Ö·û¼¯±àÂë
 * @author 17909
 *
 */
@WebFilter(urlPatterns="/*")
public class CharsetFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//ÉèÖÃ×Ö·û±àÂë¸ñÊ½
				HttpServletRequest request = (HttpServletRequest)arg0;
				HttpServletResponse response = (HttpServletResponse)arg1;
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
