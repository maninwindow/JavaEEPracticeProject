package io.javabrains;

public class TypeInferenceExample {

	public static void main(String[] args) {
		
		//StringLengthLambda myLambda = (s) -> s.length();
		//StringLengthLambda myLambda = s -> s.length(); //Braces can be removed when only one parameter.
		printLambda(s->s.length());
	}

	public static void printLambda(StringLengthLambda l){
		System.out.println(l.getLength("Hello WOrld!"));
	}
	
	interface StringLengthLambda{
		int getLength(String s);
	}
}
