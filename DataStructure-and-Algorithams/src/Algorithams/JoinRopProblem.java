package Algorithams;

import java.util.PriorityQueue;

public class JoinRopProblem {

	public static void main(String[] args) {
		int len[] = { 4, 3, 2, 6 };
		int size = len.length;

		System.out.println("Total cost for connecting ropes is " + minCost(len, size));

	}

	/**
	 * 	1) Create a min heap and insert all lengths into the min heap.
		2) Do following while number of elements in min heap is not one.
			a) Extract the minimum and second minimum from min heap
			b) Add the above two extracted values and insert the added value to the min-heap.
			c) Maintain a variable for total cost and keep incrementing it by the sum of extracted values.
		3) Return the value of this total cost.

	 * @param len
	 * @param n
	 * @return
	 */
	static int minCost(int len[], int n) {
		int cost = 0; // Initialize result

		if (n > 0) {
			PriorityQueue<Integer> p = new PriorityQueue<Integer>();
			for (int i = 0; i < n; i++) {
				p.add(len[i]);
			}
			int r1 = p.poll();
			int r2 = 1;

			cost = r1;

			if (n > 1) {
				r2 = p.poll();
				cost = r1 + r2;
				p.add(cost);
			}
			n--;
			while (p.size() > 1) {
				r1 = p.poll();
				r2 = p.poll();
				cost += r1 + r2;
				p.add(r1 + r2);
			}
		}

		return cost;
	}

}
