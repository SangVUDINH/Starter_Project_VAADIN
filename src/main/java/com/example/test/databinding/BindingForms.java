package com.example.test.databinding;

import java.time.LocalDate;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
@SuppressWarnings("serial")
public class BindingForms extends HorizontalLayout {
	
	private static Product createProduct() {
		final Product product = new Product();
		product.setName("Testproduct");
		product.setAvailable(LocalDate.of(2050, 1, 1));
		return product;
	}
	
	public BindingForms() {
		final Product product = createProduct();
	
		ProductViewer productViewer = new ProductViewer(product);
		productViewer.setWidth("30%");
		
		ProductEditor productEditor = new ProductEditor(product, productViewer :: refresh);
		productEditor.setWidth("50%");
		
		add(productEditor, productViewer);
		
		getThemeList().set("spacing", true);
	}

}
