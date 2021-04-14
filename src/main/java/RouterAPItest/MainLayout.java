package RouterAPItest;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class MainLayout extends Composite<VerticalLayout> implements HasComponents, RouterLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Div childWraper = new Div();
	
	public MainLayout() {
		setId("main-layout");
		
		getContent().setSizeFull();
		H1 header1 = new H1("Header");
		Div header = new Div();
		header.add(header1);
		add(header);
		
		HorizontalLayout mainContent = new HorizontalLayout();
		VerticalLayout menuBar = new VerticalLayout();
		menuBar.setWidth("20%");
		menuBar.setId("menu-bar");
		
		menuBar.add(creerRouterLink("Home", HomeView.class));
		menuBar.add(creerRouterLink("Lottery", LotteryView.class));
		

//	    menuBar.add( creerRouterLink("Theming1", Exercise1.class));
//	    menuBar.add( creerRouterLink("Theming2", Exercise2.class));
//	    menuBar.add( creerRouterLink("Theming3", Exercise3.class));
//	    menuBar.add( creerRouterLink("Components", ComponentContainer.class));
		
		mainContent.add(menuBar);
		add(new Anchor("logout", "Logout"));
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

	
	private RouterLink creerRouterLink(String caption, Class<? extends Component> viewClass) {
		final RouterLink routerLink = new RouterLink(null, viewClass);
		routerLink.add(new Span(caption));
		routerLink.setClassName("menu-link");
		return routerLink;
	}
	
	
	
}
