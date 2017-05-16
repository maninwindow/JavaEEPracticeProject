package lambda.myPractice;

import java.util.Arrays;
import java.util.List;

public class Practice01 {

	private static boolean getString;
	private static long getSize;
	private static Object[] toArray;

	public static void main(String[] args) {
		List<String> nameList = Arrays.asList("Alimjan","Yasenjan","Adiljan","","");
		getString = nameList.stream().anyMatch(n -> n.equals("Alimjan"));
		System.out.println("Is value exist: "+getString);
		
		getSize = nameList.stream().count();
		System.out.println("List size: "+getSize);
		
		toArray = nameList.stream().toArray();
		for(Object s : toArray){
			System.out.println("To Array: "+s.toString());
		}
	}
}
