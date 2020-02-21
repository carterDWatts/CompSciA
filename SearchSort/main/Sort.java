package main;

import java.io.File;
import java.util.*;
import javax.swing.JFileChooser;

public class Sort{
  
  private static int mergeStep = 0;
	private static int[] integers = new int[10000];
	private static int[][] temps = new int[3][10000];
	private static int[] occurances = new int[10];

	public static void main(String[] args){
		
    JFileChooser fc = new JFileChooser();
		Scanner s = new Scanner(System.in);
		System.out.println("Choose file to load.");
		int result = fc.showOpenDialog(fc);
		
    if (result == JFileChooser.APPROVE_OPTION){
			File file = fc.getSelectedFile();
			try{createData(file);} 
			catch (Exception e){e.printStackTrace();}
			String path = file.getAbsolutePath();
			System.out.println(path + " is now loaded in.");
			System.out.println();
		}
		setTemps();
		displaySteps();
		showFrequencies();
		
	}

	// fills the array with data from the txt file
	public static void createData(File f) throws Exception{
		String currentLine;
		int i = 0;
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()){
			currentLine = sc.nextLine();
			integers[i] = Integer.parseInt(currentLine);
			i++;
		}
	}

	// sets the temp arrays equal to original data to be used by sorts
	public static void setTemps(){
		for (int i = 0; i < temps.length; i++){
			for (int j = 0; j < integers.length; j++){
				temps[i][j] = integers[j];
			}
		}
	}

	// prints arrays - for testing
	public static void printArray(int[] array){
		for (int i : array){System.out.println(i);}
	}

	public static void printArray(int[][] array){
		for (int[] i : array){
			for (int j : i){System.out.print(j + " ");}
			System.out.println();
		}
	}
	
	//displays the amount of steps each sorting algorthm takes
	public static void displaySteps(){
		System.out.println("Selection Sort");
		selectionSort(temps[0]);
		System.out.println("Insertion Sort");
		insertionSort(temps[1]);
		System.out.println("Merge Sort");
		mergeSort(temps[2]);
	}
	
	public static void showFrequencies(){
	  System.out.println("Occurances of");
    for(int i : integers){occurances[i-1]++;}
		for(int i = 0; i < occurances.length;i++){
			System.out.println((i+1)+": "+occurances[i]);
		}
	}
	
	public static int[] selectionSort(int[] elements){
		int selectionSteps = 0;
		for (int j = 0; j < elements.length - 1; j++){
			int minIndex = j;
			for (int k = j + 1; k < elements.length; k++){
				if (elements[k] < elements[minIndex]){
					minIndex = k;
				}
				selectionSteps++;
			}
			int temp = elements[j];
			elements[j] = elements[minIndex];
			elements[minIndex] = temp;
		}
		System.out.println("Steps:" + selectionSteps);
		System.out.println();
		return elements;
	}

	public static int[] insertionSort(int[] elements){
		int steps = 0;
		int whileCount = 0;
		for (int j = 1; j < elements.length; j++){
			int temp = elements[j];
			int possibleIndex = j;
			while (possibleIndex > 0 && temp < elements[possibleIndex - 1]){
				whileCount++;
				elements[possibleIndex] = elements[possibleIndex - 1];
				possibleIndex--;
			}
			steps++;
			elements[possibleIndex] = temp;
		}
		System.out.println("Steps:" + (steps + whileCount));
		System.out.println();
		return elements;
	}

	public static int[] mergeSort(int[] elements){
		int n = elements.length;
		int[] temp = new int[n];
		mergeSortHelper(elements, 0, n - 1, temp);
		System.out.println("Steps:" + mergeStep);
		System.out.println();
		return elements;
	}

	private static void mergeSortHelper(int[] elements, int from, int to, int[] temp){
		if (from < to){
			int middle = (from + to) / 2;
			mergeSortHelper(elements, from, middle, temp);
			mergeSortHelper(elements, middle + 1, to, temp);
			merge(elements, from, middle, to, temp);
		}
	}

	private static void merge(int[] elements, int from, int mid, int to, int[] temp){
		int i = from;
		int j = mid + 1;
		int k = from;

		while (i <= mid && j <= to){
			mergeStep++;
			if (elements[i] < elements[j]){
				temp[k] = elements[i];
				i++;
			} else{
				temp[k] = elements[j];
				j++;
			}
			k++;
		}
		while (i <= mid){
			temp[k] = elements[i];
			i++;
			k++;
		}
		while (j <= to){
			temp[k] = elements[j];
			j++;
			k++;
		}
		for (k = from; k <= to; k++){
			elements[k] = temp[k];
		}
	}
}
