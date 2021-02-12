package com.example.test;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class VaadinBoardExo extends VerticalLayout {
	
	public VaadinBoardExo() {
		
		Board board = new Board();
		board.addRow(getPieChart(), getPieChart());
		
		add(board);
	}

	private Component getPieChart() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
