package com.example.test;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("test")
public class HelloWorld extends Div {
    public HelloWorld() {
        setText("Hello world");
    }
}