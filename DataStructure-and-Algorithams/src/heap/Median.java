package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median {


		//To hold the smaller element
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	    //to hold the large element
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
	    /** initialize your data structure here. */
	    public Median() {
	        
	    }
	    
	    public static void main(String[] args) {
	    	int[] arr = new int[]{5, 15, 10, 20, 3}; 
	        printMedian(arr);
	    }
	    
	    private static void printMedian(int[] arr) {
	    	
	    	for(int i=0; i<arr.length; i++) {
	    		System.out.println("num : "+arr[i]);
	    		addNum(arr[i]);
	    		System.out.println("median :"+ findMedian());
	    		System.out.println("min heap : "+minHeap);
	    		System.out.println("max heap : "+maxHeap);
	    		System.out.println("-----");
	    	}
	    }
	    
	    public static void addNum(int num) {
	    	
	        //add element in minHeap
	    	minHeap.add(num);
	    	
	    	//remove top element(max element from smaller number heap) from min heap
	    	num = minHeap.poll();
	    	
	    	// add removed element to max heap
	    	maxHeap.add(num);
	    	
	    	//if size of max heap  greater than min heap
	    	if(maxHeap.size() > minHeap.size()) {
	    		//remove top element(min element from larger number heap) from max heap
	    		num = maxHeap.poll();
	    	
	    		//add it to max heap
	    		minHeap.add(num);
	    	}
	    }
	    
	    public static double findMedian() {
	    	//both same size
	    	if(minHeap.size() >0 ) {
		        if(minHeap.size() == maxHeap.size() ) {
		        	return (double)(minHeap.element()+maxHeap.element())/2;
		        }
		        	
		        //min heap bigger size
		        if(minHeap.size()> maxHeap.size()) {
		        	return minHeap.element();
		        }
	    	}
			return 0;
	    }
	    
}
