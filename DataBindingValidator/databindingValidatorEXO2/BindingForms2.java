package databindingValidatorEXO2;

import java.time.LocalDate;

import com.example.test.databinding.Product;
import com.example.test.databinding.ProductViewer;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@SuppressWarnings("serial")
public class BindingForms2 extends HorizontalLayout{
	
	private static Product createProduct() {
		final Product product = new Product();
		product.setName("Testproduct");
		product.setAvailable(LocalDate.of(2050, 1, 1));
		return product;
	}
	
	public BindingForms2() {
		final Product product = createProduct();
		
		ProductViewer2 productViewer = new ProductViewer2(product);
		
		ProductEditor2 productEditor = new ProductEditor2(product, productViewer::refresh);
		
		
		add(productEditor, productViewer);
		
	}

}
