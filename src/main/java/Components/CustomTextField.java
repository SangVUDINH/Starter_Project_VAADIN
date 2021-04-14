package Components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.shared.Registration;

import Event.ChangeEvent;

@Tag("input")
public class CustomTextField extends Component {
	
	

	public CustomTextField(String value) {
		getElement().setProperty("value",value);

	}
	
	// add event listener methode
	// ComponentEventListener<ChangeEvent> listener est une Interface
	public Registration  addChangeListener1( ComponentEventListener<ChangeEvent> listener) {
		return addListener(ChangeEvent.class, listener);
	}
	
	
	@Synchronize("change")
	public String getValue() {
	    return getElement().getProperty("value");
	}
	
	// add fire event
	public void setValue(String value) {
	    getElement().setProperty("value", value);
	    
	    fireEvent(new ChangeEvent(this, false));
	}
	
}
