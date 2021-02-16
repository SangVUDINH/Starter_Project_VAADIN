package dataGridList;

import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LocalDateRenderer;

@SuppressWarnings("serial")
public class CreateDataProdiver extends VerticalLayout {

	final PersonService service = new PersonService();
	public CreateDataProdiver() {
		
		setWidth("100%");
		
		final List<PersonModel> persons = service.getAllPersons();
		final Grid<PersonModel> grid = new Grid<>();
		
		add(grid);
		
		// on ajoute des data dans les grilles
		grid.setItems(persons);
		
		// mode manuel 
		grid.addColumn(PersonModel::getName).setHeader("Name");
		grid.addColumn(PersonModel::getEmail).setHeader("Email");
		grid.addColumn(PersonModel::getAge).setHeader("Age");
		grid.addColumn(new LocalDateRenderer<>(PersonModel::getBirthday)).setHeader("Birthday");
		
		
	}
}
