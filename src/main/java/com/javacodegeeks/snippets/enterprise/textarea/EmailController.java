package com.javacodegeeks.snippets.enterprise.textarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javacodegeeks.snippets.enterprise.textarea.model.Email;


@Controller
@RequestMapping("/email.htm")
public class EmailController {

    @Autowired
    @Qualifier("emailValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model){
		Email email = new Email();
		model.addAttribute("email", email);
		return "email";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
		Model model, @Validated Email email, BindingResult result) {
		String returnVal = "successEmail";
		if(result.hasErrors()) {
			returnVal = "email";
		} else {
			model.addAttribute("email", email);
		}		
		return returnVal;
	}

}