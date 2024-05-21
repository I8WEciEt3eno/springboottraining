package jp.shoheisawachika.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController extends CommonController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request, Model model) {
        return "hello";
    }
}