package com.javacodegeeks.snippets.enterprise.radiobutton.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javacodegeeks.snippets.enterprise.radiobutton.model.Order;


public class OrderValidator implements Validator {

		public boolean supports(Class<?> paramClass) {
			return Order.class.equals(paramClass);
		}

		public void validate(Object obj, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "flavors", "valid.flavors");
		}
}