package jp.shoheisawachika.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class MessageUtil {
	
	public static final String KEY_ERROR_MESSAGE_LIST = "errorMessageList";
	public static final String KEY_INFO_MESSAGE_LIST = "infoMessageList";
	
	private static MessageService messageService;
	
	public static void setMessageService(MessageService messageService){
		MessageUtil.messageService = messageService;
	}
	
	private MessageUtil() {
		
	};
	
    public static void addMessage2Model(Model model, String messageCode, String[] params) {
    	if (model == null || messageCode == null) {
    		return;
    	}
    	String message = messageService.getMessage(messageCode, params);
    	if (messageCode.startsWith("systemMessage.error.")) {
    		addErrorMessage2Model(model, message);
    	} else if (messageCode.startsWith("systemMessage.info.")) {
    		addInfoMessage2Model(model, message);
    	}
    }
	
    public static void addErrorMessage2Model(Model model, String errorMessage) {
    	if (model == null) {
    		return;
    	}
    	List<String> messageList;
    	Object o = model.getAttribute(KEY_ERROR_MESSAGE_LIST);
    	if (o instanceof List) {
    		messageList = autoCast(o);
    	} else {
    		messageList = new ArrayList<>();
    	}
    	messageList.add(errorMessage);
    	model.addAttribute(KEY_ERROR_MESSAGE_LIST, messageList);
    }
	
    public static void addInfoMessage2Model(Model model, String infoMessage) {
    	if (model == null) {
    		return;
    	}
    	List<String> messageList;
    	Object o = model.getAttribute(KEY_INFO_MESSAGE_LIST);
    	if (o instanceof List) {
    		messageList = autoCast(o);
    	} else {
    		messageList = new ArrayList<>();
    	}
    	messageList.add(infoMessage);
    	model.addAttribute(KEY_INFO_MESSAGE_LIST, messageList);
    }
	
    public static void addMessage2RedirectAttributes(RedirectAttributes redirectAttributes, String messageCode, String[] params) {
    	if (redirectAttributes == null || messageCode == null) {
    		return;
    	}
    	String message = messageService.getMessage(messageCode, params);
    	if (messageCode.startsWith("systemMessage.error.")) {
    		addErrorMessage2RedirectAttributes(redirectAttributes, message);
    	} else if (messageCode.startsWith("systemMessage.info.")) {
    		addInfoMessage2RedirectAttributes(redirectAttributes, message);
    	}
    }
	
    public static void addErrorMessage2RedirectAttributes(RedirectAttributes redirectAttributes, String errorMessage) {
    	if (redirectAttributes == null) {
    		return;
    	}
    	List<String> messageList;
    	Object o = redirectAttributes.getAttribute(KEY_ERROR_MESSAGE_LIST);
    	if (o instanceof List) {
    		messageList = autoCast(o);
    	} else {
    		messageList = new ArrayList<>();
    	}
    	messageList.add(errorMessage);
    	redirectAttributes.addFlashAttribute(KEY_ERROR_MESSAGE_LIST, messageList);
    }
	
    public static void addInfoMessage2RedirectAttributes(RedirectAttributes redirectAttributes, String infoMessage) {
    	if (redirectAttributes == null) {
    		return;
    	}
    	List<String> messageList;
    	Object o = redirectAttributes.getAttribute(KEY_INFO_MESSAGE_LIST);
    	if (o instanceof List) {
    		messageList = autoCast(o);
    	} else {
    		messageList = new ArrayList<>();
    	}
    	messageList.add(infoMessage);
    	redirectAttributes.addFlashAttribute(KEY_INFO_MESSAGE_LIST, messageList);
    }
    
	@SuppressWarnings("unchecked")
	private static <T> T autoCast(Object obj) {
	    T castObj = (T) obj;
	    return castObj;
	}
}
