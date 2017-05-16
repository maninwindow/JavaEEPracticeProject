package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {
	
	public static void main(String[] args) {
		 List<Person> ppl = Arrays.asList(
				 new Person("Alimjan","Mettursun",26),
				 new Person("Eli","Ismayil",26),
				 new Person("Abliz","Yusun",26),
				 new Person("Gulnisahan","Mettohti",26)
				 );
		 
		 //Step1: Sort list by last name
		 Collections.sort(ppl, new Comparator<Person>(){

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
			 
		 });
		 
		 //SStep2: Create a method that prints all elements in the list
		 System.out.println("Print all persons");
		 printAll(ppl);
		 
		 //Step3: Create a method that prints all people that have last name beginning with M
		 System.out.println("Print all persons lastname starts with M");
		 printConditionally(ppl,new Condition(){

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("M");
			}
			 
		 });
	}
	
	private static void printLastNameBeginWithM(List<Person> ppl) {
		for(Person p : ppl){
			if(p.getLastName().startsWith("M")){
				System.out.println(p);
			}
		}
	}
	
	private static void printConditionally(List<Person> ppl, Condition condition) {
		for(Person p : ppl){
			if(condition.test(p)){
				System.out.println(p);
			}
		}
	}

	private static void  printAll(List<Person> ppl){
		for(Person p : ppl){
			System.out.println(p);
		}
	}
	
	interface Condition{
		boolean test(Person p);
	}
}

