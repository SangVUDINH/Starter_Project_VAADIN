package com.example.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.example.test.components.HomeViewElement;
import com.example.test.components.LoginViewElement;
import com.example.test.components.MainLayoutElement;
import com.vaadin.testbench.RetryRule;



public class HomeViewIT extends AbstractViewTest {

	public HomeViewIT() {
		super("");
	}
	

	@Test
	public void homePage() {
		LoginViewElement loginViewElement = $(LoginViewElement.class).waitForFirst();
		Assert.assertTrue(loginViewElement.loginButton());
		
		MainLayoutElement mainLayoutElement= $(MainLayoutElement.class).first();

		Assert.assertTrue(mainLayoutElement.hasMenuLink("Home"));
		
		mainLayoutElement.clickMenuLink("Home");
		
		HomeViewElement homeViewElement= $(HomeViewElement.class).waitForFirst();
		homeViewElement.confirmeBtn();
		homeViewElement.cancelBtn();
	}
}
