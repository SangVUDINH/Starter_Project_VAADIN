package Components;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ViewComponent2 extends VerticalLayout {
	
	private H2 eventDisplay;
	public ViewComponent2() {
		H2 header = new H2("Component B ");
		
		eventDisplay = new H2("No EVENT");
		
		add(header, eventDisplay);		
		
	}
	
	public void EventChecked() {
		eventDisplay.setText("EVENT FIRED, COMPONENT VIEW DISPLAY");
	}

}
