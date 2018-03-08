package com.javacodegeeks.snippets.enterprise.radiobutton;

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

import com.javacodegeeks.snippets.enterprise.radiobutton.model.Order;

@Controller
@RequestMapping("/order.htm")
public class OrderController {

    @Autowired
    @Qualifier("orderValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		Order order = new Order();
		order.setSize("big");
		order.setFlavors("");
		model.addAttribute("order", order);
		initModelList(model);
		return "order";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, @Validated Order order, BindingResult result) {
		model.addAttribute("order", order);
		String returnVal = "successOrder";
		if(result.hasErrors()) {
			initModelList(model);
			returnVal = "order";
		} else {
			model.addAttribute("order", order);
		}		
		return returnVal;
	}

	private void initModelList(Model model) {
		List<String> flavorslist = new ArrayList<String>();
		flavorslist.add("chocolate");
		flavorslist.add("banana");
		flavorslist.add("strawberry");
		flavorslist.add("mango");
		flavorslist.add("cherry");
		model.addAttribute("flavors", flavorslist);
	}
}
