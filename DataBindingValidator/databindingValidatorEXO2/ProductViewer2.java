package databindingValidatorEXO2;

import java.time.LocalDate;

import com.example.test.databinding.Product;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ReadOnlyHasValue;

public class ProductViewer2 extends Composite<FormLayout> {
	
	private final Paragraph nameText = new Paragraph();
	private final Paragraph priceText = new Paragraph();
	private final Paragraph availableText = new Paragraph();
	
	private Binder<Product> binder = new Binder<>(Product.class);
	
	public ProductViewer2 (Product product) {
		
		final FormLayout layout = getContent();
		
		layout.addFormItem(nameText, "Name");
		layout.addFormItem(priceText, "Price");
		layout.addFormItem(availableText, "Available");
		
		// on bind les field pour la lecture seulement
		binder.forField(new ReadOnlyHasValue<String>(
				name-> nameText.setText(name)
				))
				.bind(Product::getName,null);
		binder.forField(new ReadOnlyHasValue<Double>(price -> priceText.setText(String.valueOf(price))))
			.bind(Product::getPrice,null);
	
		binder.forField(new ReadOnlyHasValue<LocalDate>(available-> availableText.setText(String.valueOf(available) )))
			.bind(Product::getAvailable, null);
		
		// init les data du champs / 1er lecture
		refresh(product);
	}
	
	void refresh(Product product) {
		binder.readBean(product);
	}

}
