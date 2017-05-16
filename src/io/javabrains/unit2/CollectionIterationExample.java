package io.javabrains.unit2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import io.javabrains.Person;

public class CollectionIterationExample {
	
	public static void main(String[] args) {
		 List<Person> ppl = Arrays.asList(
				 new Person("Alimjan","Mettursun",26),
				 new Person("Eli","Ismayil",26),
				 new Person("Abliz","Yusun",26),
				 new Person("Gulnisahan","Mettohti",26)
				 );
		 
		 List<Person> ppl1 = Arrays.asList(
				 new Person("1","2",26),
				 new Person("a","s",26),
				 new Person("d","f",26),
				 new Person("x","c",26)
				 );
		 
		 //ppl.forEach(p -> System.out.println(p));
		 //ppl.forEach(System.out::println);
		 //ppl1.forEach(System.out::println);
		 
		 ppl.stream()
		 .filter(p -> p.getFirstName().startsWith("A"))
		 .forEach(p -> System.out.println(p.getLastName()));
		 
		 //Stream<Person> stream = ppl.stream();
	}
}
