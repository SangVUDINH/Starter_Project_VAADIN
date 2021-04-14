package Event;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

import RouterAPItest.MainLayout;

public class UIEventBus extends VerticalLayout{

	public UIEventBus () {

		System.out.println(UI.getCurrent().getChildren().filter(component -> 
	            		component.getClass() == MainLayout.class).findFirst().orElse(null)	   				
				);
		
		//MainLayout main = (MainLayout) UI.getCurrent().getChildren().filter(component -> component.getClass() == MainLayout.class).findFirst().orElse(null);
		
		//main.add(new H2("add new"));
		
		add(new H2("groupe de boutons"));
		for (int i = 0 ; i<5; i++) {
			add(new MyButton());
		}
	}
	
	
	// EVENT class
	private class ButtonActivateEvent extends ComponentEvent<Button>{
		
		public ButtonActivateEvent(Button source, boolean fromClient) {
			super(source, fromClient);
		}
	}
	
	
	
	private class MyButton extends Button {
		private Registration registration;
		
		private MyButton () {
			// setText click me !
			deactivate();
			
			addClickListener(event ->{
				// change text BTN
				activate(); 
				//condition onclick fire event, on recupere UI(components) actuel
				//puis on lance event ButtonActivateEvent qu'on a cree plus haut
				
				ComponentUtil.fireEvent(UI.getCurrent(), new ButtonActivateEvent(this,false));
			});
			
		}
		
		// ADD event listener via Registration
		@Override
		protected void onAttach(AttachEvent attachEvent) {
			super.onAttach(attachEvent);
			
			//register to events from the event bus (attribut du class MyButton), add listener to all MyButton instance
			registration = ComponentUtil.addListener(
					UI.getCurrent(), ButtonActivateEvent.class, event ->{
						// seul le button qui envoie l'event n'est pas affecté
						if (event.getSource() != this) {
							deactivate();
						}
					});
		}
		
		// methode désabonner de l'event
		@Override
        protected void onDetach(DetachEvent detachEvent) {
            super.onDetach(detachEvent);
            // Unregister from the event bus
            registration.remove();
        }
		
		
		
		
		private void deactivate()
		{
			this.setText("Click me !");
		}
		
		private void activate() {
			this.setText("Activated !");
		}
		
	}
	
}
