package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.javabrains.Unit1ExerciseSolutionJava7.Condition;

public class Unit1ExerciseSolutionJava8 {
	public static void main(String[] args) {
		 List<Person> ppl = Arrays.asList(
				 new Person("Alimjan","Mettursun",26),
				 new Person("Eli","Ismayil",26),
				 new Person("Abliz","Yusun",26),
				 new Person("Gulnisahan","Mettohti",26)
				 );
		 
		 //Step1: Sort list by last name
		 Collections.sort(ppl, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
		 
		 //SStep2: Create a method that prints all elements in the list
		 System.out.println("Print all persons");
		 
		 //Step3: Create a method that prints all people that have last name beginning with M
		 System.out.println("Print all persons lastname starts with M");
		 printConditionally(ppl,p -> p.getLastName().startsWith("M"));
	}
	
	private static void printConditionally(List<Person> ppl, Condition condition) {
		for(Person p : ppl){
			if(condition.test(p)){
				System.out.println(p);
			}
		}
	}

}
