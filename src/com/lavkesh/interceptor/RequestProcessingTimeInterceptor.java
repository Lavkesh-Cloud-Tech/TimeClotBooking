/**
 * 
 */
package com.lavkesh.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 244821
 *
 */
public class RequestProcessingTimeInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(RequestProcessingTimeInterceptor.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		String requestURI = request.getRequestURI();
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = Calendar.getInstance().getTimeInMillis();
		logger.info("Request URI:: {} -> Time taken:: {}", requestURI, (endTime - startTime));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		String requestURI = request.getRequestURI();
		long startTime = Calendar.getInstance().getTimeInMillis();
		logger.info("Request URI:: {} -> Sent to handler current time:: {} ", requestURI, startTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestURI = request.getRequestURI();
		long startTime = Calendar.getInstance().getTimeInMillis();
		logger.info("Request URI:: {} -> Start time:: {}", requestURI, startTime);
		request.setAttribute("startTime", startTime);
		return true;
	}

}