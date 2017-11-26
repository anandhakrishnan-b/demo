package com.sangam.demo;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
	
	public static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
	public static final String REQUEST_INTERCEPTOR_ID="INTERCEPTOR_ID";


 @Override
 public boolean preHandle(HttpServletRequest request, 
		HttpServletResponse response, Object object) throws Exception {
	MDC.put(REQUEST_INTERCEPTOR_ID, UUID.randomUUID().toString());
	String requestURI = request.getRequestURI();
	logger.info("RequestURI={} starts here",requestURI);
	return true;
 }

 @Override
 public void postHandle(HttpServletRequest request, HttpServletResponse response, 
		Object object, ModelAndView model)
		throws Exception {
	 String requestURI = request.getRequestURI();
	 logger.info("RequestURI={} ends here",requestURI);
 }

 @Override
 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
		Object object, Exception arg3)
		throws Exception {
	 MDC.clear();
 }
}