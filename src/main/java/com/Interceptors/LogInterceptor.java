package com.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		
		 RequestMapping requestmapping = ((HandlerMethod) handler).getMethodAnnotation(
	              RequestMapping.class);
		 

		
		
		boolean requestPage = requestmapping != null && requestmapping.value().length > 0
                && "login".equals(requestmapping.value()[0]);
		
		boolean isAuth = request.getSession().getAttribute("userAuth") !=null ;
		
		if (isAuth && requestPage) {
			response.sendRedirect(request.getRequestURI());
			return false;
			
		}
		
		else if (!isAuth && !requestPage) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		return true;
    }
	

}
