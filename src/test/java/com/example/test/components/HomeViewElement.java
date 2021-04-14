package com.example.test.components;

import org.junit.Assert;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.dialog.testbench.DialogElement;
import com.vaadin.flow.component.html.testbench.SpanElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.annotations.Attribute;

@Attribute(name = "id", value = "home-view")
public class HomeViewElement extends TestBenchElement {
	
	public void confirmeBtn() {
		ButtonElement button = $(ButtonElement.class).first();
		button.click();
		
		DialogElement dialog = $(DialogElement.class).onPage().first();
		Assert.assertTrue(dialog.isOpen());
		
		ButtonElement buttonConfirm = dialog.$(ButtonElement.class).id("confirmbtn-home-view");
		System.out.println(buttonConfirm.getText());
		buttonConfirm.click();
		
		Assert.assertFalse(dialog.isOpen());
		SpanElement  spanElement = $(SpanElement.class).id("message-home-view");
		
		Assert.assertEquals("Confirmed!", spanElement.getText());
	}
	
	public void cancelBtn() {
		ButtonElement button = $(ButtonElement.class).first();
		button.click();
		
		DialogElement dialog = $(DialogElement.class).onPage().first();
		Assert.assertTrue(dialog.isOpen());
		
		ButtonElement buttonConfirm = dialog.$(ButtonElement.class).id("cancel-home-view");
		System.out.println(buttonConfirm.getText());
		buttonConfirm.click();
		
		Assert.assertFalse(dialog.isOpen());
		SpanElement  spanElement = $(SpanElement.class).id("message-home-view");
		
		Assert.assertEquals("Cancelled...", spanElement.getText());
	}
	
	
}
