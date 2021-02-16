package databinding;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ReadOnlyHasValue;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToIntegerConverter;

public class FormBinding extends VerticalLayout {

	public FormBinding () {
		TextField firstnameField = new TextField("firstname");
		TextField lastnameField = new TextField("lastname");
		TextField ageField = new TextField("age");
		
		// binding via methode reference  // safe lorsqu'on change de nom des attributs class
		Binder<Person> binder = new Binder<>();
		
		binder.forField(firstnameField)
			.withValidator(new MyCustomValidator())
			.bind(
					Person::getFirstname,
					Person::setFirstname);
		
		binder.forField(lastnameField)
		.bind(
				Person::getLastname,
				Person::setLastname);
		
		binder.forField(ageField).withConverter(new StringToIntegerConverter("Must enter a number")).bind(Person::getAge,Person::setAge);
		
		Person sang = new Person("Sang","VD",25);
		
		//binder.setBean(sang);
		//binder.readBean(sang);
		
		Button saveButton = new Button("Save", event ->   {
			try  {
				System.out.println(sang.getFirstname());
				binder.writeBean(sang);
				binder.readBean(sang);
				
			} catch (ValidationException e) {
				e.getStackTrace();
			}
		});
		
		Button cancelButton = new Button("Cancel", event->  {
			binder.readBean(sang);
		});
		
		
		add(firstnameField, lastnameField, ageField, saveButton, cancelButton);
		
		// READ DATA
		Div divText = new Div();
		ReadOnlyHasValue<String> firstnameRead = new ReadOnlyHasValue<> (text->  {
			divText.setText(text);
		});
		
		binder.forField(firstnameRead).bind(Person::getFirstname, null);
		
		add(divText);
		
		binder.readBean(sang); // MAJ binded FIELDs
		
		
	}
}
