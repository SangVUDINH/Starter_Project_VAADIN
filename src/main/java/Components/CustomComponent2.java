package Components;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;

import Event.VaadinEvent;

public class CustomComponent2 extends VerticalLayout {

	private TextField textInput;
	private Button btnValid;
	public CustomComponent2 () {
		
		H2 header = new H2("Component A");
		textInput = new TextField();
		btnValid = new Button("Check", e->  {
			checkEvent();
		});
		
		add (header,textInput, btnValid);
	}
	
	// add event listener methode
	// ComponentEventListener<ChangeEvent> listener est une Interface
	public Registration  addChangeListener1( ComponentEventListener<VaadinEvent> listener) {
		return addListener(VaadinEvent.class, listener);
	}
	
	public void checkEvent() {
		String valueInput = textInput.getValue();
		if (valueInput.equals("Vaadin")) {			
			fireEvent(new VaadinEvent(this,false));
		}
	}
}
