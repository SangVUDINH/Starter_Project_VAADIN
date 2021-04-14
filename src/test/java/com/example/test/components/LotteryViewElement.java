package com.example.test.components;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.html.testbench.DivElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.annotations.Attribute;
import com.vaadin.testbench.elementsbase.Element;

@Element("vaadin-vertical-layout")
@Attribute(name = "id", value = "lottery-view")
public class LotteryViewElement extends TestBenchElement {
	
	public void tryValue(String luckyNumber) {
		ButtonElement button = this.$(ButtonElement.class).first();		
		Assert.assertEquals("Try my luck!", button.getText());
		
		TextFieldElement inputTextField = this.$(TextFieldElement.class).first();
		Assert.assertEquals("Input your number", inputTextField.getPlaceholder());
		
		inputTextField.setValue(luckyNumber);
		button.click();
		
		DivElement divResult = this.$(DivElement.class).id("div-result");
		assertTrue(divResult.getText().equals("Congrats, you win!") ||
				divResult.getText().equals("Sorry, better luck next time."));
		
	}
}
