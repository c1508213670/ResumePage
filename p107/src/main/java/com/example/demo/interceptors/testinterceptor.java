 package com.example.demo.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojo.Person;

public class testinterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession(); // 判断session
			// 从session中取出用户身份信息
			Person user= (Person) session.getAttribute("person");
			//如果设置为true时，请求将会继续执行后面的操作
			//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
			if (user != null) return true;
			// 如果执行到这里，说明非法访问，让其跳转到登陆页面
				request.getRequestDispatcher("/load").forward(request, response);
			} catch (IOException e) {
			e.printStackTrace();
			}
			return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
