package io.javabrains.unit2;

public class MethodReferenceExample1 {

	public static void main(String[] args) {
		Thread t = new Thread(MethodReferenceExample1::printMessage);// Equivalent to () -> System.out.println("Hello");
		t.start();
	}
	
	public static void printMessage(){
		System.out.println("Hello");
	}

}
