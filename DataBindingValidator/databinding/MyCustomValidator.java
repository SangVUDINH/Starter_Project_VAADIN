package databinding;

import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.binder.ValueContext;

public class MyCustomValidator implements Validator<String>{

	@Override
	public ValidationResult apply(String value, ValueContext context) {
		if (value == null || value.length() <3) {
			return ValidationResult.error("String is too short");
		} else {
			return ValidationResult.ok();
		}
		
	}	
}
