package com.example.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.OptionalParameter;

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
		content.setHeightFull();
		content.getStyle().set("display","flex");			
		content.setClassName("content");
		content.setText("This is the content Area");
		content.getStyle().set("alignmentContent","start");	
		
		// remplir l'espace
		layout.expand(content);
		layout.add(navigation, content);
		
		layout.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
		
		updateUIForScroll();
			
	}
	
	private Div createBlock() {
		final Div button = new Div();
		button.setText("Block");
		button.getStyle().set("background", "white");
		button.getStyle().set("margin", "5px");
		button.setHeight("100px");
		button.setWidth("100px");
		
		return button;
	}
	
	
	public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
		if("scroll".contentEquals(parameter)) {
			updateUIForScroll();
		}
	}
	
	private void updateUIForScroll() {
		final Button add = new Button("Add", e-> {
			content.add(createBlock());
		});
		
		navigation.setText(null);
		content.setText(null);
		navigation.add(add);
		
		makeContentScrollable();
	}
	
	private void makeContentScrollable() {
		content.getStyle().set("flexWrap", "wrap");
		content.getStyle().set("overFlowY", "auto");
	}
	
	
}
