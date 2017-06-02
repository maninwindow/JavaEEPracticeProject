package alim.sorts;

public class Utils {
	public static void swapValues(int[] theArray,int indexOne, int indexTwo){
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
	}
	
	public static void printHorzArray(int[] theArray,int i, int j){
		
        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < theArray.length; n++){

            System.out.print("| " + n + "  ");

        }

        System.out.println("|");


        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < theArray.length; n++){

            System.out.print("| " + theArray[n] + " ");

        }

        System.out.println("|");

        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        // END OF FIRST PART


        // ADDED FOR BUBBLE SORT

        if(j != -1){
            // ADD THE +2 TO FIX SPACING
            for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
            System.out.print(j);

        }


        // THEN ADD THIS CODE

        if(i != -1){

            // ADD THE -1 TO FIX SPACING

            for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
            System.out.print(i);

        }

        System.out.println();

    }
}
