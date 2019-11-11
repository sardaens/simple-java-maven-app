package com.mycompany.app;

/**
 * Hello world!
 */
public class App
{

    private final String message = "Hello World!";

    public App() {
    	// empty for a good reason ;-)
    }

    public static void main(String[] args) {
        System.out.println(new App().getMessage());
        System.out.println(new MathService().add(5, 3));
    }

    private final String getMessage() {
        return message;
    }

}
