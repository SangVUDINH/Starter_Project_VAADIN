package dataProviderFiltre;

import java.time.LocalDate;

import com.example.test.databinding.Product;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.LocalDateRenderer;

public class FilteringDataProvider extends Composite<VerticalLayout> {
	
	private final ListDataProvider<Product> dataProvider;
	
	public FilteringDataProvider () {
		final VerticalLayout layout = getContent();
		layout.setWidth("100%");
		
		// list data 
		dataProvider = DataProviderHelper.createProductDataProvider();
		
		// layout date fields
		final DatePicker fromField = new DatePicker("Start");
		final DatePicker toField = new DatePicker("End");
		final Button btnFilter = new Button("Filter");
		final HorizontalLayout layoutFilters = new HorizontalLayout(fromField, toField, btnFilter);
		
		btnFilter.addClickListener( e->{
			
			dataProvider.setFilter(Product::getAvailable, 
					available -> 
						filterProduct(available, fromField.getValue(), toField.getValue())			
					);			
		});
		
		layout.add(layoutFilters);
		
		// create and populate grid
		final Grid<Product> grid = new Grid<>();
		
		grid.setWidth("90%");
		
		// inject des data dans les grilles
		grid.setDataProvider(dataProvider);
		
		grid.addColumn(new LocalDateRenderer<>(Product::getAvailable)).setHeader("Available");
		grid.addColumn(Product::getName).setHeader("Name");
		grid.addColumn(Product::getPrice).setHeader("Price");
		
		layout.add(grid);
	}
	
	private boolean filterProduct(LocalDate available, LocalDate start, LocalDate end) {

		//final LocalDate available = product.getAvailable();

		// Null checks
		if (available == null) {

			if (start != null || end != null) {
				// data is null, but user wants to filter; assume false
				return false;
			}
			return true;
		}

		if (start == null && end == null) {

			return true;

		} else if (start == null) {

			return available.isBefore(end) || available.equals(end);

		} else if (end == null) {

			return available.isAfter(start) || available.equals(start);

		} else {

			final boolean atEnds = available.equals(start) || available.equals(end);
			final boolean inbetween = available.isAfter(start) && available.isBefore(end);

			return atEnds || inbetween;
		}
	}
}
