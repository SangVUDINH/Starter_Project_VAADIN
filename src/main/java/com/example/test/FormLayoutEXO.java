package com.example.test;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementFactory;

public class FormLayoutEXO extends VerticalLayout{

	public FormLayoutEXO() {
		setSizeFull();
		
		FormLayout formLayout = new FormLayout();
		
		TextField firstName = new TextField();
		firstName.setWidth("100%");
		formLayout.addFormItem(firstName, "First Name");
		
		TextField lastName = new TextField();
		lastName.setWidth("100%");
		formLayout.addFormItem(lastName, "Last Name");
		
		TextField email = new TextField();
		email.setWidth("100%");
		//etirer sur les 2 colonnes
		formLayout.addFormItem(email, "Email").getElement().setAttribute("colspan", "2");; 
		
		FlexLayout phoneLayout = new FlexLayout();
		phoneLayout.setWidth("100%");
		
		TextField phone = new TextField();
		phoneLayout.add(phone, new Checkbox("Do not call"));
		phoneLayout.expand(phone);
		FormLayout.FormItem  item = formLayout.addFormItem(phoneLayout, "Phone");
		item.getElement().setAttribute("colspan", "2");
		
		PasswordField password = new PasswordField();
		password.setWidth("100%");
		formLayout.addFormItem(password, "Password");
		
		// saut de ligne
		formLayout.getElement().appendChild(ElementFactory.createBr());
		 // ou formLayout.add( new Html("<br/>");
		
		PasswordField repeatPassword = new PasswordField();
		repeatPassword.setWidth("100%");
		formLayout.addFormItem(repeatPassword, "Repeat Password");
		
		add(formLayout);
	}
}
