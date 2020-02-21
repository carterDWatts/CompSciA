package main;
public class ReverseSorts {

  public static void main(String[] args) {
	  int[] nums= {4,7,2,8,3,5};
		selectionSort(nums);
			
		for (int i = 0; i < nums.length; i++ )
		System.out.print(nums[i] + " ");
			
	}

	public static void selectionSort (int[] numbers) {
		int max, temp;

	  for (int index = 0; index < numbers.length-1; index++) {
	    max = index;
	    for (int scan = index+1; scan < numbers.length; scan++)
	  	  if (numbers[scan] > numbers[max])
	    	  max = scan;
	  
			temp = numbers[max];
	    numbers[max] = numbers[index];
	    numbers[index] = temp;
		}
	}

	public static void insertionSort (int[] numbers) {
		for (int index = 1; index < numbers.length; index++) {
			int key = numbers[index];
		  int position = index;
			while (position > 0 && numbers[position-1] < key) {
		  	numbers[position] = numbers[position-1];
		    position--;
		  }
			numbers[position] = key;
		}
	}

}
