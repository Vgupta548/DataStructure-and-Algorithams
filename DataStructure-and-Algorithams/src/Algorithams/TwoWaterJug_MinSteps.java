package Algorithams;

public class TwoWaterJug_MinSteps {

	public static void main(String[] args) {
		int n = 3, m = 5, d = 5;
		System.out.println(minStep(n, m, d));
		System.out.println(minStep(4, 3, 2));
	}
	
	static int minStep(int n, int m , int d) {
		
		if(n > m) {
			n = n+m;
			m = n-m;
			n = n-m;
		}
		
		if(d>m){
			return -1;
		}
		
		if(d %  GCD.gcd(n, m) != 0) {
			return -1;
		}
		return Math.min(pour(n,m,d), pour(m,n,d));
	}
	
	static int pour(int fromCap, int toCap, int d) {
		System.out.println(fromCap +" : "+toCap);
		int steps = 0;
		
		int from = fromCap;
		int to = 0;
		
		steps++;
		while(from != d && to !=d) {
			//System.out.println("from :"+fromCap +" toCap ß: "+toCap);
			int temp = Math.min(from, toCap-to);
			
			to = to+temp;
			from = from -temp;
			
			steps++;
			
			if(from == d || to == d) {
				break;
			}
			
			if(from == 0) {
				from = fromCap;
				steps ++;
			}
			
			if(to == toCap) {
				to = 0;
				steps++;
			}
		}
		System.out.println("step :"+steps);
		return steps;
		
	}

}
