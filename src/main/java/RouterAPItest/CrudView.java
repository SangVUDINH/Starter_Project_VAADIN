package RouterAPItest;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;



@Route(value="crud", layout = MainLayout.class)
@PageTitle("CRUD")
public class CrudView extends Composite<VerticalLayout> implements HasComponents{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CrudView () {
		
	}
}	
