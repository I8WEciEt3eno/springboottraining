package jp.shoheisawachika.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends CommonController {

    @GetMapping({"/", "/home"})
    public String home(HttpServletRequest request, Model model) {
        return "home";
    }

}
