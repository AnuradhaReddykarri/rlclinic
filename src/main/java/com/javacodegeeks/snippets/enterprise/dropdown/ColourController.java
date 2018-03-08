package com.javacodegeeks.snippets.enterprise.dropdown;

import java.util.ArrayList;
import java.util.List;

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

import com.javacodegeeks.snippets.enterprise.dropdown.model.Colour;

@Controller
@RequestMapping("/colour.htm")
public class ColourController {

    @Autowired
    @Qualifier("colourValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		Colour colour = new Colour();
		model.addAttribute("colour", colour);
		initModelList(model);
		return "colour";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, @Validated Colour colour, BindingResult result) {
		model.addAttribute("colour", colour);
		String returnVal = "successColour";
		if(result.hasErrors()) {
			initModelList(model);
			returnVal = "colour";
		} else {
			model.addAttribute("colour", colour);
		}		
		return returnVal;
	}

	private void initModelList(Model model) {
		List<String> coloursList = new ArrayList<String>();
		coloursList.add("red");
		coloursList.add("green");
		coloursList.add("yellow");
		coloursList.add("pink");
		coloursList.add("blue");
		model.addAttribute("colours", coloursList);
	}
}
