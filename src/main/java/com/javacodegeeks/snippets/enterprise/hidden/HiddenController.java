package com.javacodegeeks.snippets.enterprise.hidden;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javacodegeeks.snippets.enterprise.hidden.model.HiddenMessage;


@Controller
@RequestMapping("/hidden.htm")
public class HiddenController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		HiddenMessage hiddenMsg = new HiddenMessage();
		hiddenMsg.setMessage("Hello Geeks!!");
		model.addAttribute("message", hiddenMsg);
		return "hidden";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, HiddenMessage hiddenMsg, BindingResult result) {
		model.addAttribute("message", hiddenMsg);		
		return "successHidden";
	}
}
