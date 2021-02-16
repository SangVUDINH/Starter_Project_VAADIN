package databindingValidatorEXO;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;

public class ValidationTemplate extends VerticalLayout{
	
	public ValidationTemplate() {
		
		final Binder<FormValueModel> binder = new Binder<>(FormValueModel.class);
		
		//affectation / pointer d'instance FormValueModel
		binder.setBean(new FormValueModel());
		
		final EmailField emailField = new EmailField("Email Validator");
		binder.forField(emailField).withValidator(new EmailValidator("not a good e-mail"))
			.bind(FormValueModel::getEmailValue, FormValueModel:: setEmailValue);
		
		final TextField stringField = new TextField("String length validator");
		binder.forField(stringField).withValidator(new StringLengthValidator("string length should be more than 5 characters",5,50))
				.bind(FormValueModel:: getStringValue, FormValueModel::setStringValue);
		
		final TextField vaadinField = new TextField("Vaadin validator");
		binder.forField(vaadinField).withValidator(
				(value,context)->{
					if(value == null || "".equals(value) || value.equals("Vaadin")) {
						return ValidationResult.ok();
					}else {
						return ValidationResult.error(value+" not accepted");
					}
		}).bind(FormValueModel::getVaadinValue, FormValueModel::setVaadinValue);
		
		
		
		add(emailField, stringField, vaadinField);
		
	}

}
