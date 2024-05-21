package jp.shoheisawachika.presentation.myprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jp.shoheisawachika.SbtException;
import jp.shoheisawachika.domain.MyprofileService;
import jp.shoheisawachika.domain.model.MyprofileDto;
import jp.shoheisawachika.presentation.CommonController;
import jp.shoheisawachika.util.MessageUtil;
import jp.shoheisawachika.util.SystemMessage;

@Controller
public class MyprofileController extends CommonController {

	@Autowired
	MyprofileService myprofileService;
	
    @GetMapping("/myprofile")
    public String myprofile(HttpServletRequest request, Model model) throws SbtException {
    	MyprofileDto dto = myprofileService.initializeForm();
    	if (dto == null || dto.getId().equals("4")) {
            throw new SbtException("test exception.");
        }
    	MyprofileForm form = MyprofileForm.builder()
        		.id(dto.getId())
        		.name(dto.getName())
        		.cleartextPassword("")
        		.description(dto.getDescription())
        		.build();
    	model.addAttribute("myprofileForm", form);
    	return "myprofile";
	
    }

    //TODO 0429 Validationがきかない. html側でth:objectとth:fieldを使用するように修正すればいい？
    @PostMapping("/myprofile/update")
    public String update(@ModelAttribute @Validated MyprofileForm form, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()){
        	MessageUtil.addMessage2Model(model, SystemMessage.ERR00001, null);
        	return "myprofile";
        }
    	MyprofileDto dto = new MyprofileDto(form);
    	myprofileService.update(dto);
    	MessageUtil.addMessage2Model(model, SystemMessage.INF00003, null);
    	return "myprofile";
    }

    @PostMapping("/myprofile/changePassword")
    public String changePassword(@ModelAttribute MyprofileForm form, Model model) {
    	MyprofileDto dto = new MyprofileDto(form);
    	myprofileService.changePassword(dto);
    	MessageUtil.addMessage2Model(model, SystemMessage.INF00003, null);
    	return "myprofile";	
    }
}
