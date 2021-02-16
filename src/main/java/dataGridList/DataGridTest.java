package dataGridList;

import com.vaadin.flow.component.grid.Grid;

import databinding.Person;

public class DataGridTest {
	
	public DataGridTest() {
		// scan and add colums auto
		//Grid<Person> grid = new Grid<>(Person.class);
		
		// manuel mode
		Grid<Person> grid = new Grid<>();
		
		// add columns manually
		grid.addColumn(Person::getFirstname);
		
		// builder renderer (template html/vaadin)
		
	}
}
