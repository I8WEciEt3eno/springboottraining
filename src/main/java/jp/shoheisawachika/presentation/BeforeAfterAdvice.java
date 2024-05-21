package jp.shoheisawachika.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.shoheisawachika.BuildInfoProperty;

@ControllerAdvice
public class BeforeAfterAdvice {

	private Logger log = LoggerFactory.getLogger(BeforeAfterAdvice.class);

	@Autowired
	public BuildInfoProperty buildInfoProperty;
	
    @ModelAttribute
    public void addAttributes(Model model) {
        // コントローラーの前処理として実行する共通処理
        model.addAttribute("buildInfoProperty", buildInfoProperty);
    }
    
    @ExceptionHandler
    public String handleException(Throwable e) {
        log.error("System Error occurred.", e);
        e.printStackTrace();
        return "error";
    }
}