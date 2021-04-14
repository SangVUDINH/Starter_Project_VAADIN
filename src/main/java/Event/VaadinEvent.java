package Event;

import com.vaadin.flow.component.ComponentEvent;

import Components.CustomComponent2;

public class VaadinEvent extends ComponentEvent<CustomComponent2> {
	
	public VaadinEvent(CustomComponent2 source, boolean fromClient) {
		
		super(source, fromClient);
	}
}
