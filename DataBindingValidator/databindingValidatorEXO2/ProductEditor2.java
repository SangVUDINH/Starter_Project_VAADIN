package databindingValidatorEXO2;

import java.util.function.Consumer;

import com.example.test.databinding.CurrencyConverter;
import com.example.test.databinding.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;

public class ProductEditor2 extends VerticalLayout {

	public ProductEditor2(Product product, Consumer<Product> productConsumer) {
		
		//instancier les fields
		final ProductFormLayout2	productLayout = new ProductFormLayout2();
		
		final Binder<Product> binder = new Binder<>(Product.class);
		
		binder.bindInstanceFields(productLayout);
		
		binder.forField(productLayout.getPriceField()).withConverter(new CurrencyConverter())
			.bind(Product::getPrice,Product::setPrice);
		
		binder.forField(productLayout.getAvailableField())
			.bind(Product::getAvailable, Product::setAvailable);
		
		// lecture product
		binder.readBean(product);
		
		final HorizontalLayout footer = new HorizontalLayout();
		
		footer.add(new Button("Save",
					event->{
						try {
							binder.writeBean(product);
							// fnc refresh readBean
							productConsumer.accept(product);
						} catch ( final ValidationException e) {							
							e.printStackTrace();
						}
					}
				));
		
		footer.add(new Button("Cancel", 
				event -> binder.readBean(product)
				));
		
		add(productLayout, footer);
	
	}
}
