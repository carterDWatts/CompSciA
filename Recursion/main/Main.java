package main;
public class Main{

	public static void main(String[] args){
		int[] data = {4,6,3,2,5,7,3,3,0};	
		System.out.println(a(data,0));
		
	}
	public static int a(int[] data, int start){
		if (start == data.length - 1){
			return data[start];
		}
		int val = a(data,start-1);
		if (val > data[start]){
			return val;
		}else{
			return data[start];
		}
	}

}
