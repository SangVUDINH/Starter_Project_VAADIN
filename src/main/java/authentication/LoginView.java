package authentication;


import java.util.Collections;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Login | Vaadin CRM")
public class LoginView extends VerticalLayout implements BeforeEnterObserver,AfterNavigationObserver {
	
	private static final long serialVersionUID = 5853034700254012935L;
	
	LoginForm  login = new LoginForm();
	
	public LoginView() {

		setSizeFull();
		
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);
		
		login.setAction("login");
		
		add(
				new H1("Vaadin CRM"), 
				login);
		
	}
	
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		// check if we ve a parameter error
		if(!event.getLocation()
				.getQueryParameters()
				.getParameters()
				.getOrDefault("error", Collections.emptyList())
				.isEmpty()) {
			login.setError(true);
		}
		
	}
	
	@Override
	public void afterNavigation(AfterNavigationEvent event) {

	}




	
}