package com.javacodegeeks.snippets.enterprise.dropdown.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javacodegeeks.snippets.enterprise.dropdown.model.Colour;

public class ColourValidator implements Validator {

		public boolean supports(Class<?> paramClass) {
			return Colour.class.equals(paramClass);
		}

		public void validate(Object obj, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "colourName", "valid.colour");
		}
}