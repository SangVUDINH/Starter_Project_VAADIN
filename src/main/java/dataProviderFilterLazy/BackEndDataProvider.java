package dataProviderFilterLazy;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.Route;

import dataGridList.PersonModel;


public class BackEndDataProvider extends VerticalLayout {
	
	final PersonService service = new PersonService();
	
	public BackEndDataProvider () {
		setWidth("100%");
		
		// agegroupe des intervals de chiffres
		final List<AgeGroup> groups = new ArrayList<>();
		groups.add(new AgeGroup(0, 18));
		groups.add(new AgeGroup(19, 26));
		groups.add(new AgeGroup(27, 40));
		groups.add(new AgeGroup(41, 100));
		
		final ComboBox<AgeGroup> filter = new ComboBox<>("Filter", groups);
		add(filter);
		
		final Grid<PersonModel> grid = new Grid<>();
		grid.setWidth("90%");
		add(grid);
		
		//create dataprovider using PersonService
		final CallbackDataProvider<PersonModel, AgeGroup> dataProvider = DataProvider.fromFilteringCallbacks(
					q-> service.getPersons(q.getOffset(), q.getLimit(), q.getFilter().orElse(null)),
					q-> service.countPersons(q.getOffset(), q.getLimit(), q.getFilter().orElse(null))
				);
		// offset limit filter sont des parametres pour utiliser STREAM.filter()	
		
		//A data provider that supports programmatically setting a filter that will be applied to all queries.
		// application du filtre ??   à revoir
		final ConfigurableFilterDataProvider<PersonModel, Void, AgeGroup> filterProvider= dataProvider.withConfigurableFilter();
		
		// inject filtered data to grid
		grid.setDataProvider(filterProvider);
		
		// refresh lors d'un changement interval
		filter.addValueChangeListener(e->{
			final AgeGroup value = e.getValue();
			filterProvider.setFilter(value); // à revoir plus en details
		});

		grid.addColumn(PersonModel::getName).setHeader("Name").setKey("name");
		grid.addColumn(PersonModel::getEmail).setHeader("Email").setKey("email");
		grid.addColumn(PersonModel::getAge).setHeader("Age").setKey("age");
		grid.addColumn(new LocalDateRenderer<>(PersonModel::getBirthday)).setHeader("Birthday").setKey("birthday");
	}
}
