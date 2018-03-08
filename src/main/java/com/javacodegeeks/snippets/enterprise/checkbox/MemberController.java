package com.javacodegeeks.snippets.enterprise.checkbox;

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

import com.javacodegeeks.snippets.enterprise.checkbox.model.Member;


@Controller
@RequestMapping("/member.htm")
public class MemberController {

    @Autowired
    @Qualifier("memberValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		Member member = new Member();
		List<String> preCheckedVals = new ArrayList<String>();
		preCheckedVals.add("Yoga");
		member.setCourses(preCheckedVals);
		model.addAttribute("member", member);
		initModelList(model);
		return "member";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, @Validated Member member, BindingResult result) {
		model.addAttribute("member", member);
		String returnVal = "successMember";
		if(result.hasErrors()) {
			initModelList(model);
			returnVal = "member";
		} else {
			model.addAttribute("member", member);
		}		
		return returnVal;
	}

	private void initModelList(Model model) {
		List<String> courses = new ArrayList<String>();
		courses.add("Yoga");
		courses.add("Stretching");
		courses.add("Pilates");
		courses.add("Aerobic");
		courses.add("Oriental");
		model.addAttribute("courses", courses);
	}
}
