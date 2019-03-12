package com.rockit.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session过滤器
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
        // TODO Auto-generated method stub  
        HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) res;  
        HttpSession session = request.getSession();  
        // 如果session不为空，则可以浏览其他页面  
        String url = request.getServletPath();  
        //这里判断目录，后缀名，当然也可以写在web.xml中，用url-pattern进行拦截映射  
        if ((!request.getServletPath().equals("/dashboard.rkt"))  
                && (!request.getServletPath().equals("/index.jsp"))
                && (!request.getServletPath().equals("/ssologinnew.jsp"))
                && (!request.getServletPath().equals("/rkt/login.rkt"))
                && (!request.getServletPath().equals("/RktCheckCode"))) {  
            if (session.getAttribute("rktCurrentUser") == null) {  
                session.invalidate();  
                response.setContentType("text/html;charset=gb2312");  
                String loginUrl = request.getContextPath() + "/index.jsp";
                if (request.getHeader("x-requested-with") != null
                        && request.getHeader("x-requested-with")
                                .equalsIgnoreCase("XMLHttpRequest")) {
                	response.addHeader("sessionstatus", "timeOut");
                	response.addHeader("loginPath", loginUrl);
                    chain.doFilter(request, response);// 不可少，否则请求会出错
                } else{
                	String str = "<script language='javascript'>alert('会话过期,请重新登录');"
                            + "window.top.location.href='"
                            + loginUrl
                            + "';</script>";
                    response.setContentType("text/html;charset=UTF-8");// 解决中文乱码
                    try {
                        PrintWriter writer = response.getWriter();
                        writer.write(str);
                        writer.flush();
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
            } else {  
                chain.doFilter(request, response);  
            }  
        } else {  
            chain.doFilter(request, response);  
        }  
  
    }  
  
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
