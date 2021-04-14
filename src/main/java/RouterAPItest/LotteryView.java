package RouterAPItest;

import java.util.Random;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;

@Route(value="lottery", layout = MainLayout.class)
public class LotteryView extends Composite<VerticalLayout> implements HasComponents, HasUrlParameter<Integer> ,BeforeLeaveObserver {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Div lotteryResult = new Div();
	private final TextField numberInput = new TextField();
	
	public LotteryView () {
		setId("lottery-view");
		
		add( new H2("Lottery View"));
		
		HorizontalLayout inputBar = new HorizontalLayout();
		
		numberInput.setPlaceholder("Input your number");		
		inputBar.add(numberInput);		
		
		
		Button button = new Button("Try my luck!", e->
			{
				final String value = numberInput.getValue();
				if (value != null || !value.isEmpty()) {
					final Integer number = Integer.parseInt(value);
					
					validate(number);
					updateContent(number);
				}
			}
		);
		button.setEnabled(false);
		numberInput.addValueChangeListener(e->{
			button.setEnabled(e.getValue() !=null && !e.getValue().isEmpty());
			}
		);
		inputBar.add(button);
		
		
		lotteryResult.setId("div-result");
		add(inputBar);
		add(lotteryResult);
		
		
	}
	
	private void updateContent(Integer number) {
		if (number == null) {
			lotteryResult.setText("");
		} else {
			final int luckyNumber = new Random().nextInt(10) + 1;
			StringBuilder builder = new StringBuilder();
			if(number.equals(luckyNumber)){
				builder.append("Congrats, you win! ");
			}else{
				builder.append("Sorry, better luck next time. ");
			}
			//builder.append("Your number is: ").append(number).append(", the lucky number is:").append(luckyNumber);

			lotteryResult.setText(builder.toString());
		}
	}

	private void validate(Integer number){
		if(number!=null){
			if(number<1 || number >10){
				throw new InvalidValueException();
			}
		}
	}

	@Override
	public void setParameter(BeforeEvent event,@OptionalParameter Integer parameter) {		
		if(parameter !=null) {
			validate(parameter);
			numberInput.setValue(String.valueOf(parameter));
		}
	}
	
	@Override
	public void beforeLeave(BeforeLeaveEvent event) {
		if(numberInput!=null && !numberInput.isEmpty()){
			BeforeLeaveEvent.ContinueNavigationAction action = event.postpone();
			Dialog confirmDialog = new Dialog();
			Paragraph text = new Paragraph("Are you sure you want to leave this page?");
			Button confirmButton = new Button("Confirm", e -> {
				action.proceed();
				confirmDialog.close();
			});
			Button cancelButton = new Button("Cancel", e->confirmDialog.close());
			confirmDialog.add(text, new HorizontalLayout(confirmButton, cancelButton));
			confirmDialog.open();
		}
	}

}
