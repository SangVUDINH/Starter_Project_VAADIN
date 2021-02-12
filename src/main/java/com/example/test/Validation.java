package com.example.test;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;

public class Validation extends VerticalLayout {

	public Validation() {
		final Binder<FormValue> binder = new Binder<>(FormValue.class);
		
		binder.setBean(new FormValue());
		
		final EmailField emailField = new EmailField("Email validator");
		binder.forField(emailField)
			.withValidator(new EmailValidator("Are you sure the given valid"))
			.bind(FormValue::getEmailValue, FormValue::setEmailValue);
		
		final TextField stringField = new TextField("String length validator");
		binder.forField(stringField).withValidator(new StringLengthValidator("Error length max 10",0,10))
			.bind(FormValue::getStringValue,FormValue::setStringValue);
		
		// CUSTOM VALIDATOR
		final TextField vaadinField = new TextField("Vaadin validator");
		binder.forField(vaadinField).withValidator(
				(value,context)->{
					if (value ==null || "".contentEquals(value) || value.contentEquals("Vaadin")) {
						return ValidationResult.ok();
					} else {
						return ValidationResult.error(value+" not accepted");
					}
		}) . bind(FormValue::getVaadinValue, FormValue::setVaadinValue);
		
		add(emailField,stringField, vaadinField);
	}
	
	

}
