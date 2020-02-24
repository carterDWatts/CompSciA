package main;
public class Main{

	public static void main(String[] args){
		
		b(5);
		
	}

	public static void a(int n){
		if (n > 0){
			a(n-1);
		}
		System.out.println(n);
	}

	public static void b(int n){
		if(n>0){
			b(n-1);
			System.out.println(n);
		}
	}

	public static void c(int n){
		if(n>0){
			c(n-1);
		}else{
			System.out.println(n);
		}
	}
		

}
