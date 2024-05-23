package jp.shoheisawachika.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
	
	private Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	String message = String.format("http Request: [%s] %-4s %s", request.getLocalAddr(), request.getMethod(), request.getRequestURI()); 
    	log.info(message);
    	return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	String message = String.format("http Response: [%s] %s %s - %d %s",
    			request.getLocalAddr(), request.getMethod(), request.getRequestURI(), response.getStatus(), HttpServletResponse.SC_OK == response.getStatus() ? "OK" : "ERROR");
    	log.info(message);
    }
}