package main;
public class GCD {

    public static void main(String[] args) {
        int n1 = 3388, n2 = 436;
        System.out.print( gcd(n1, n2) );
    }

    public static int gcd(int n1, int n2){
        if (n2 != 0)
            return gcd(n2, n1 % n2);
        else
            return n1;
    }
}
