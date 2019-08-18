package Algorithams.Mathematics;

import java.util.ArrayList;
import java.util.List;

public class Divisor {

	public static void main(String[] args) {
		printDivisor(100);
		System.out.println("==");
		printDivisorInSortedOrder(100);
	}
	
	private static void printDivisor(int n) {
		
		for(int i = 2; i<=Math.sqrt(n); i++ ) {
			
			if(n % i == 0) {
				if( n%i == i) {
					System.out.println(i +" ");
				}else {
					System.out.println(i +" "+ n/i + " ");
				}
			}
		}
	}
	
private static void printDivisorInSortedOrder(int n) {
	
		List<Integer> list = new ArrayList();
		
		for(int i = 2; i<=Math.sqrt(n); i++ ) {
			
			if(n % i == 0) {
				System.out.print(i + " ");
				if( n%i != i) {
					list.add(n/i);
				}
			}
		}
		
		for(Integer i : list) {
			System.out.print(i + " ");
		}
	}
	
}
