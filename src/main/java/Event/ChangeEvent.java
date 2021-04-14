package Event;

import com.vaadin.flow.component.ComponentEvent;

import Components.CustomTextField;


public class ChangeEvent extends ComponentEvent<CustomTextField> {
	
	public ChangeEvent(CustomTextField source, boolean fromClient) {
		
		super(source, fromClient);
	}

}
