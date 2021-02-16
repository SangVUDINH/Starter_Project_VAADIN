package databindingValidatorEXO2;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.PropertyId;

public class ProductFormLayout2 extends VerticalLayout {
	
	// style composant 
	@PropertyId("name")
	final private TextField nameField = new TextField("Name");	
	final private TextField priceField = new TextField("Price");
	final private DatePicker availableField = new DatePicker("Available");
	
	public ProductFormLayout2() {
		add(nameField, priceField, availableField);
	}

	public TextField getNameField() {
		return nameField;
	}

	public TextField getPriceField() {
		return priceField;
	}

	public DatePicker getAvailableField() {
		return availableField;
	}
	
	

}
