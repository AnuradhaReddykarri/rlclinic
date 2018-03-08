package com.javacodegeeks.snippets.enterprise.password;

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

import com.javacodegeeks.snippets.enterprise.password.model.Password;

@Controller
@RequestMapping("/password.htm")
public class PasswordController {

    @Autowired
    @Qualifier("passwordValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model){
		Password password = new Password();
		model.addAttribute("password", password);
		return "password";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
		Model model, @Validated Password password, BindingResult result) {
		String returnVal = "successPwd";
		if(result.hasErrors()) {
			returnVal = "password";
		} else {
			model.addAttribute("password", password);
		}		
		return returnVal;
	}

}