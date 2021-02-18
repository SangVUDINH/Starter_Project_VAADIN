package RouterAPItest;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="home", layout = MainLayout.class)
@PageTitle("HOME")
public class HomeView extends Composite<VerticalLayout> implements HasComponents {

	public HomeView() {
		add(new H2("Welcome to lottery!"));
	}
}
