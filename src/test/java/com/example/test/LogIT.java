package com.example.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.example.test.components.LoginViewElement;
import com.example.test.components.MainLayoutElement;
import com.vaadin.testbench.RetryRule;


public class LogIT extends AbstractViewTest   {
    public LogIT() {
        super("");
    }
    
	
	@Test
	public void login() {
		LoginViewElement loginViewElement = $(LoginViewElement.class).waitForFirst();

		Assert.assertFalse(loginViewElement.loginButtonFail());
		Assert.assertTrue(loginViewElement.loginButton());
	}
	
	@Test
	public void logout() {
		LoginViewElement loginViewElement = $(LoginViewElement.class).waitForFirst();
		Assert.assertTrue(loginViewElement.loginButton());
		
		MainLayoutElement mainLayoutElement= $(MainLayoutElement.class).first();
		Assert.assertTrue(mainLayoutElement.hasMenuLink("Logout"));
		mainLayoutElement.clickMenuLink("Logout");
		
		Assert.assertTrue($(LoginViewElement.class).onPage().exists());
	}
}
	

