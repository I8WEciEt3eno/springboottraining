package jp.shoheisawachika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jp.shoheisawachika.presentation.LoggingInterceptor;
import jp.shoheisawachika.presentation.UserInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
    @Autowired
    private UserInterceptor userInterceptor;
	
    @Autowired
    private LoggingInterceptor loggingInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 全てのパスに対してインターセプターを適用
//        registry.addInterceptor(userInterceptor).addPathPatterns("/**");
        registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
    }
	
/*
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
*/
	
}
