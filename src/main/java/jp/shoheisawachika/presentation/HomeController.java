package jp.shoheisawachika.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends CommonController {

    @GetMapping({"/", "/home"})
    public String home(HttpServletRequest request, Model model) {
    	
    	/*
    	List<String[]> outpt = new ArrayList<String[]>();
    	String path = "";
    	File file = new File(path);
    	try (CSVReader csvReader = new CSVReader(new FileReader(file))) {            
    		outpt = csvReader.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            //throw new Exception();
        }
        */
    	
        return "home";
    }

}
