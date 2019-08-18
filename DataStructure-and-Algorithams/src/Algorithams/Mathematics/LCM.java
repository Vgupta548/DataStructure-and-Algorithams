package Algorithams.Mathematics;

public class LCM {

	public static void main(String[] args) {
		int a = 15, b = 20; 
        System.out.println("LCM of " + a +" and " + b + " is " + lcm(a, b)); 
    } 
	
	// a x b = LCM(a, b) * GCD (a, b)
	//   LCM(a, b) = (a x b) / GCD(a, b) 
	static int lcm(int a, int b) 
    { 
        return (a*b)/GCD.gcd(a, b); 
    } 

}
