package com.example.test;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Exo1 extends VerticalLayout {
	
	private final HorizontalLayout layout;
	private Div navigation;
	private Div content;
	
	public Exo1 () {
		
		setPadding(false);
		setSpacing(false);
		setSizeFull();
		setDefaultHorizontalComponentAlignment(Alignment.STRETCH);		
		
		final Div header = new Div();
		header.setText("This is the header. My height is 150px");
		header.setClassName("header");
		header.setHeight("150px");
		header.getStyle().set("flexShrink", "0");
		
		layout = new HorizontalLayout();		
		layout.setHeightFull();
		layout.setSpacing(false);
		createTextLayout();
		
		final Div footer = new Div();
		footer.getStyle().set("flexShrink", "0");
		footer.setText("This is the footer area. My height is 100 pixels");
		footer.setClassName("footer");
		footer.setHeight("100px");
		
		add(header);
		add(layout);
		add(footer);
		
		expand(layout);
	}
	
	private void createTextLayout() {
		navigation = new Div();
		navigation.setClassName("navigation");
		navigation.setWidth("25%");
		navigation.getElement().getStyle().set("flexShrink", "0");
		navigation.setText("This is the navigation area. My width is 25% of the application layout.");
		
		content = new Div();		
		content.getStyle().set("display","flex");			
		content.setClassName("content");
		content.setText("This is the content Area");
		content.getStyle().set("alignmentContent","start");	
		
		// remplir l'espace
		layout.expand(content);
		layout.add(navigation, content);
		
		layout.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
			
	}
}
