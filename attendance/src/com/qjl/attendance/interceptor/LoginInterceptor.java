package com.qjl.attendance.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qjl.attendance.entity.Admin;

/**
 * 类描述：登录验证的拦截器
 * 全限定性类名: com.qjl.attendance.interceptor.LoginInterceptor
 * @author 曲健磊
 * @date 2018年8月30日下午9:35:46
 * @version V1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 验证当前用户是否登录过系统
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin != null) { // 用户已经登录过
			return true;
		}
		request.getRequestDispatcher("/gotoLogin").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
