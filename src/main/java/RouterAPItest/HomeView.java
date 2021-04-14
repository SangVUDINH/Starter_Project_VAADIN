package RouterAPItest;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="home", layout = MainLayout.class)
@PageTitle("HOME")
public class HomeView extends Composite<VerticalLayout> implements HasComponents {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeView() {
		setId("home-view");
		
		
		add(new H2("Welcome to lottery!"));
		
		//DIALOG		
  		Dialog dialog = new Dialog();

  		dialog.setCloseOnEsc(false);
  		dialog.setCloseOnOutsideClick(false);

  		Span message = new Span();
  		message.setId("message-home-view");

  		Button confirmButton = new Button("Confirm", event -> {
  		    message.setText("Confirmed!");
  		    dialog.close();
  		});
  		
  		confirmButton.setId("confirmbtn-home-view");
  		
  		Button cancelButton = new Button("Cancel", event -> {
  		    message.setText("Cancelled...");
  		    dialog.close();
  		});
  		cancelButton.setId("cancel-home-view");
  		dialog.add(confirmButton, cancelButton);
  		
  		Button button = new Button("dialog");
  		button.addClickListener(event -> dialog.open());
  		
  		add(button, message);
	}
}
