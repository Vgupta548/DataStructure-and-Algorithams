package Algorithams;

import java.util.HashSet;
import java.util.Set;

public class TwoWaterJug_Steps {

	public static void main(String[] args) {
		int n = 3, m = 5, d = 5;
		System.out.println(waterJugSolver(n, m, 0, 0, d, new HashSet<String>()));
		System.out.println(waterJugSolver(4, 3, 0, 0, 2, new HashSet<String>()));

	}
	
	
static boolean waterJugSolver(int jug1Cap, int jug2Cap, int j1, int j2, int d, Set<String> visited) {
		
		if((j1 == d && j2 ==0) || (j2 == d && j1==0)) {
			System.out.println(j1+","+j2);
			return true;
		}
		
		if(visited.contains(j1+","+j2)) return false;
		
		System.out.println(j1+","+j2);
		visited.add(j1+","+j2);
		
		return (waterJugSolver(jug1Cap, jug2Cap, 0, j2, d, visited) ||
				waterJugSolver(jug1Cap, jug2Cap, j1, 0, d, visited) ||
				waterJugSolver(jug1Cap, jug2Cap, jug1Cap, j2, d, visited) ||
				waterJugSolver(jug1Cap, jug2Cap, j1, jug2Cap, d, visited) ||
				waterJugSolver(jug1Cap, jug2Cap, j1+Math.min(j2, jug1Cap-j1), j2-Math.min(j2, jug1Cap-j1), d, visited) ||
				waterJugSolver(jug1Cap, jug2Cap, j1-Math.min(j1, jug2Cap-j2), j2+Math.min(j1, jug2Cap-j2), d, visited) 
				);
		
	}

}
