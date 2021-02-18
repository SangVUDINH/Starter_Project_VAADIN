package RouterAPItest;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinSession;

import theming.Exercise1;
import theming.Exercise2;
import theming.Exercise3;

@Route("")
@CssImport(value = "./styles/vaadin-text-field-yellow-bg.css", themeFor = "vaadin-text-field")
@CssImport(value = "./styles/vaadin-grid-warning.css", themeFor = "vaadin-grid")
public class MainLayout extends Composite<VerticalLayout> implements HasComponents, RouterLayout, BeforeEnterObserver {

	private Div childWraper = new Div();
	
	public MainLayout() {
		getContent().setSizeFull();
		H1 header = new H1("Header");
		add(header);
		
		HorizontalLayout mainContent = new HorizontalLayout();
		VerticalLayout menuBar = new VerticalLayout();
		menuBar.setWidth("20%");
		menuBar.add(new RouterLink("Home", HomeView.class));
		menuBar.add(new RouterLink("Lottery", LotteryView.class));
	    menuBar.add(new RouterLink("Logout", LogoutView.class));
	    menuBar.add(new RouterLink("Theming1", Exercise1.class));
	    menuBar.add(new RouterLink("Theming2", Exercise2.class));
	    menuBar.add(new RouterLink("Theming3", Exercise3.class));
		
		mainContent.add(menuBar);
		mainContent.add(childWraper);

		mainContent.setFlexGrow(1,childWraper);
		
		add(mainContent);
		
		H1 footer = new H1("Footer");
        add(footer);

        getContent().setFlexGrow(1, mainContent);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, header);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, footer);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH, mainContent);
	}

	@Override
	public void showRouterLayoutContent(HasElement content) {
		childWraper.getElement().appendChild(content.getElement());
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (VaadinSession.getCurrent().getAttribute("userLoggedIn")==null) {
			VaadinSession.getCurrent().setAttribute("intededPath", event.getLocation().getPath());
			
			event.rerouteTo(LoginView.class);
		}
		
	}
	
	
	
	
	
}
