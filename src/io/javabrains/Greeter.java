package io.javabrains;

public class Greeter {
	
	public void greet(Greeting greeting){
		greeting.perform();
	}
	
	public static void main(String[] args){
		Greeter greeter = new Greeter();
		Greeting myLambdaFunction = () -> System.out.println("Hello Wotld!");
		Greeting innerClassGreeting = new Greeting(){
			public void perform(){
				System.out.println("Hello World!");
			}
		};
		
		greeter.greet(myLambdaFunction);
		greeter.greet(innerClassGreeting);
	}
	
}
