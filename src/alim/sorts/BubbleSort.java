package alim.sorts;

public class BubbleSort {
	
	private int arraySize = 10;
	private int[] theArray = {43, 23, 11, 33, 54, 87, 14, 24, 88, 1};
	
	public static void main(String[] args){
		BubbleSort bubbleSort = new BubbleSort();
		//int[] result = bubbleSort.bubbleSortAlgo01();
		//bubbleSort.binarySearchForValue(23);
		bubbleSort.InsertionSort();
	}
	
	public int[] bubbleSortAlgo01()
	{
		for (int i = arraySize - 1;i > 0 ; i--) {
			for (int j = 0; j < i; j++) {
				if (theArray[j] > theArray[j+1]) {
					Utils.swapValues(theArray,j,j+1);
					Utils.printHorzArray(theArray,i,j);
				}
				Utils.printHorzArray(theArray,i,j);
			}
		}
		return theArray;
	}

	public void binarySearchForValue(int[] theArray,int value){
		 int lowIndex = 0;
		 int highIndex = arraySize - 1;
		 System.out.println("binary search is starting: ");
		 while (lowIndex <= highIndex) {
			int middleIndex = (highIndex + lowIndex)/2;
			if (theArray[middleIndex] < value) lowIndex = middleIndex + 1;
			else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
			else{
				System.out.println("\nFound a Match for "+value +" at index "+middleIndex);
				lowIndex = highIndex + 1;
			}
			Utils.printHorzArray(theArray,middleIndex, -1);
		}
	}

	public int[] InsertionSort(){
		for (int i = 1; i < theArray.length; i++) {
			int j = i;
			int toInsert = theArray[i];
			while ((j>0) && (theArray[j-1] > toInsert)) {
				theArray[j] = theArray[j-1];
				j--;
				Utils.printHorzArray(theArray,i,j);
			}
			theArray[j] = toInsert;
			Utils.printHorzArray(theArray,i,j);
		}
		return theArray;
	}
	
}
