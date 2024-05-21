package jp.shoheisawachika.presentation;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.shoheisawachika.util.MessageUtil;

@Component
public class MessageInterceptor implements HandlerInterceptor {
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	if (modelAndView != null && modelAndView.getModel() != null) {
    		modelAndView.addObject(MessageUtil.KEY_ERROR_MESSAGE_LIST,
    				modelAndView.getModel().get(MessageUtil.KEY_ERROR_MESSAGE_LIST));
    		modelAndView.addObject(MessageUtil.KEY_INFO_MESSAGE_LIST,
    				modelAndView.getModel().get(MessageUtil.KEY_INFO_MESSAGE_LIST));
    	}
    }
}