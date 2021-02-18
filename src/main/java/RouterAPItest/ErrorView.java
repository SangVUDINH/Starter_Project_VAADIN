package RouterAPItest;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;

public class ErrorView extends Div implements HasErrorParameter<InvalidValueException> {

	@Override
	public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<InvalidValueException> parameter) {
		setText("Oops, not a valid number");		
		return 500;
	}

	
}
