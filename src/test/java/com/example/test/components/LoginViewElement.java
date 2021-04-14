package com.example.test.components;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.textfield.testbench.PasswordFieldElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.annotations.Attribute;


@Attribute(name = "id", value = "login-view")
public class LoginViewElement extends TestBenchElement{
	
	public boolean loginButton() {

		TextFieldElement idField = $(TextFieldElement.class).id("id-field");
		PasswordFieldElement passwordField = $(PasswordFieldElement.class).id("password-field");
		idField.setValue("admin");
		passwordField.setValue("root");
		
		ButtonElement button = $(ButtonElement.class).first();
		button.click();
		// return true si on se deplace dans une autre page
		return !$(LoginViewElement.class).onPage().exists();
	}
	
	public boolean loginButtonFail() {
		TextFieldElement idField = $(TextFieldElement.class).id("id-field");
		PasswordFieldElement passwordField = $(PasswordFieldElement.class).id("password-field");
		idField.setValue("admin222");
		passwordField.setValue("root");
		ButtonElement button = $(ButtonElement.class).first();
		button.click();
		// return true si on se deplace dans une autre page
		return !$(LoginViewElement.class).onPage().exists();
	}
}
