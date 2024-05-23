package jp.shoheisawachika.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jp.shoheisawachika.util.MessageUtil;
import jp.shoheisawachika.util.SystemMessage;

@Controller
public class LoginController extends CommonController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
//    public String login(@RequestParam(value = "error", required = false) String error, HttpServletRequest request, Model model) {
    	String error = request.getParameter("error");
    	if (error != null) {
       		MessageUtil.addErrorMessage2RedirectAttributes(redirectAttributes, "Invalid username and password!");
       		MessageUtil.addMessage2Model(model, SystemMessage.ERR00001, null);
    		MessageUtil.addInfoMessage2Model(model, "Invalid username and password?");
    	}
        return "login";
    }

}
