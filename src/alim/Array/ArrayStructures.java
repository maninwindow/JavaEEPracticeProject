package alim.Array;

public class ArrayStructures {
	private int[] theArray = new int[50];
	
	private int arraySize = 10;
	
	public void generateRandomArray(){
		
		for(int i = 0;i<arraySize;i++){
			theArray[i] = (int)(Math.random()*10)+10;
		}
	}
	
	public void printArray(){
		System.out.println("----------");
		for(int i = 0 ;i<arraySize;i++){
			System.out.print("| "+i+" | ");
			System.out.println(theArray[i]+" |");
			
			System.out.println("-------------");
		}
	}
	
	public int getValueAtIndex(int index){
		if(index < arraySize) return theArray[index];
		return 0;
	}
	
	public boolean doesArrayContainThisValue(int searchValue){
		boolean valueInArray = false;
		for (int i = 0; i < arraySize; i++) {
			if (theArray[i] == searchValue) {
				valueInArray = true;
			}
		}
		return valueInArray;
	}
	
	public void deleteIndex(int index){
		if (index < arraySize) {
			for (int i = index; i < (arraySize-1); i++) {
				theArray[i] = theArray[i+1];
			}
			arraySize--;
		}
	}
	
	public void insertValue(int value){
		if (arraySize < 50) {
			theArray[arraySize] = value;
			arraySize++;
		}
	}
	
	public static void main(String[] args){
		ArrayStructures newArray = new ArrayStructures();
		
		newArray.generateRandomArray();
		
		newArray.deleteIndex(5);
		
		newArray.insertValue(33);
		
		newArray.printArray();
		
		System.out.println(newArray.getValueAtIndex(6));
		
		System.out.println(newArray.doesArrayContainThisValue(11));
	}
}
