package com.javacodegeeks.snippets.enterprise.checkbox.validator;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.javacodegeeks.snippets.enterprise.checkbox.model.Member;

public class MemberValidator implements Validator {

		public boolean supports(Class<?> paramClass) {
			return Member.class.equals(paramClass);
		}

		public void validate(Object obj, Errors errors) {
			Member member = (Member) obj;
			List<String> courses = member.getCourses();
			if (courses == null || courses.size() < 2) {
				errors.rejectValue("courses", "valid.courses");
			}
		}
}