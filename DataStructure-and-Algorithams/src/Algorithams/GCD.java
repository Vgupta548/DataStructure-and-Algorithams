package Algorithams;

public class GCD {

	public static void main(String[] args) {
		System.out.println("GCD of 3 & 5 :  "+gcd(3,5));
		System.out.println("GCD of 15 & 5 :  "+gcd(15,5));
		System.out.println("GCD of 21 & 9 :  "+gcd(21,9));
		System.out.println("GCD of 42 & 16 :  "+gcd(42,16));

	}
	
	static int gcd(int m , int n) {
		if(n == 0) return m;
		return gcd(n, m%n);
	}

}
