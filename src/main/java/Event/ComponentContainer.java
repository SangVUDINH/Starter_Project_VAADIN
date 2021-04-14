package Event;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

import Components.CustomComponent2;
import Components.ViewComponent2;
import RouterAPItest.MainLayout;

@Route(value="container", layout = MainLayout.class)
public class ComponentContainer extends VerticalLayout implements HasComponents{
	
	public H2 header;
	public ComponentContainer() {		
		
		header = new H2("parent component");
		CustomComponent2 customCMP= new CustomComponent2();		
		ViewComponent2 viewCmp = new ViewComponent2();
		
		// add listener
		Registration registration = customCMP.addChangeListener1(e-> {
			System.out.println("event fired !!!");
			viewCmp.EventChecked();
		});		
		
		UIEventBus eventBTNs = new UIEventBus();
		UIEventBus eventBTNs2 = new UIEventBus();
		
		add(header,customCMP,viewCmp, eventBTNs,eventBTNs2);
	}
}
