package com.example.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.example.test.components.LoginViewElement;
import com.example.test.components.LotteryViewElement;
import com.example.test.components.MainLayoutElement;
import com.vaadin.testbench.RetryRule;

public class LoteteryIT extends AbstractViewTest{

	public LoteteryIT() {
		super("");
		
	}
	

	@Test
	public void login() {
		LoginViewElement loginViewElement = $(LoginViewElement.class).waitForFirst();
		Assert.assertTrue(loginViewElement.loginButton());
		
		MainLayoutElement mainLayoutElement= $(MainLayoutElement.class).first();
	
		Assert.assertTrue(mainLayoutElement.hasMenuLink("Lottery"));
		
		mainLayoutElement.clickMenuLink("Lottery");
		
		LotteryViewElement lotteryViewElement = $(LotteryViewElement.class).waitForFirst();
		lotteryViewElement.tryValue("3");

	}

}
