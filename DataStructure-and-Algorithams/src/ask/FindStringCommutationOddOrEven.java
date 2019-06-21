package ask;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * input array of string and m :power
 *  summation of computed numbers from each string is odd or even
 *  computation (char[0](ascii[97-122])^m) * char[1](ascii[97-122])^m)  ... * char[n-1](ascii[97-122])^m) ) 
 *  n : length of string i
 *  sum = sum1 + sum2
 * @author vipingupta
 *
 */
public class FindStringCommutationOddOrEven {

	public static void main(String[] args) {
		 List<String> s = new ArrayList<String>();
		 s.add("aa");
		// s.add("dallas");
		// s.add("houston");
		System.out.println(solve(2, s));
	}
	
	
	public static String solve(int n, List<String> s) {
		int totalSum = 0;
		
		for(String str : s) {
			System.out.println("string : "+str);	
			int currSum = 1;
			char[] arr = str.toCharArray();
			
			for(char c: arr) {
				System.out.println("char : "+c);	
			//	int i = c;
			//	i = oneOrTwo(i);
				int currMul = getOneOrTwoAfterPower(c, n);
				System.out.println(currMul);
				currSum = currSum* currMul;
				currSum = oneOrTwo(currSum);
				System.out.println(currSum);
			}
			System.out.println(currSum);	
			totalSum +=currSum;
			
			totalSum = oneOrTwo(totalSum);
			
			System.out.println(totalSum);	
			System.out.println("==");	
		}
		
		System.out.println(totalSum);	
		if(totalSum % 2 == 0) {
			return "EVEN";
		}
		return  "ODD";
		
	}
	
	public static int oneOrTwo(long n) {
		if(n%2 == 1) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public static int getOneOrTwoAfterPower(long n, int pow) {
		if(pow == 0) return 1;
		if(n % 2 == 0) {
			return 2;
		}else {
			return 1;
		}
		
	}

}
