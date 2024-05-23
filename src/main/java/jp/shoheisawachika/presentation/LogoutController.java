package jp.shoheisawachika.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jp.shoheisawachika.util.MessageUtil;
import jp.shoheisawachika.util.SystemMessage;

@Controller
public class LogoutController extends CommonController {

    @GetMapping("/logout")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
   		MessageUtil.addMessage2RedirectAttributes(redirectAttributes, SystemMessage.INF00002, null);
        return "logout";
    }

}
