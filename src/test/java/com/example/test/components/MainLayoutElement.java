package com.example.test.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.annotations.Attribute;
import com.vaadin.testbench.elementsbase.Element;

@Element("vaadin-vertical-layout")
@Attribute(name = "id", value = "main-layout")
public class MainLayoutElement extends TestBenchElement{
	

	public List<WebElement> findMenuLinks() {
        waitUntil(driver ->"Home".equals(findElements(By.className("menu-link")).get(0).getText()));
        final List<WebElement> elements = new ArrayList<>();
        elements.addAll(findElements(By.className("menu-link")));
        return elements;
    }
	
    public void clickMenuLink(String label) {
        findMenuLinks().stream()
                .filter(elem -> elem.getText().toLowerCase()
                        .equals(label.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No " + label))
                .click();
    }
    
    public boolean hasMenuLink(String label) {
        return findMenuLinks().stream().anyMatch(elem -> elem.getText()
                .toLowerCase().equals(label.toLowerCase()));
    }
}
