package Algorithams.Mathematics;

public class GCD {

	public static void main(String[] args) {
		int n1 = 81, n2 = -153;
		
		n1 = n1>0 ? n1 : -n1;
		n2 = n2>0 ? n2 : -n2;
		
		// Everything divides 0  
        if (n1 == 0) 
        	n2 = n2;
        if (n2 == 0) 
        	n2 = n1;
        else {
			while(n1 !=n2) {
				
				if(n1 > n2) {
					n1 -= n2;
				}else {
					n2 -= n1;
				}
			}
        }
		
		System.out.println("GCD of a number is : "+n2);
		System.out.println("GCD of a number is : "+gcd(4,12));

	}
	
	static int gcd(int a, int b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 

}
