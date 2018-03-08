package com.javacodegeeks.snippets.enterprise.textarea.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javacodegeeks.snippets.enterprise.textarea.model.Email;


public class EmailValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		public boolean supports(Class<?> paramClass) {
			return Email.class.equals(paramClass);
		}

		public void validate(Object obj, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "valid.subject");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "valid.message");
			Email email = (Email) obj;
			if(!email.getReceiver().matches(EMAIL_PATTERN)) {
				errors.rejectValue("receiver","valid.receiver");
			}
			if(!email.getMessage().isEmpty()) {
				if(email.getMessage().length()<10 || email.getMessage().length()> 255) {
					errors.rejectValue("message", "valid.messageLength");
				}
			}
		}
}