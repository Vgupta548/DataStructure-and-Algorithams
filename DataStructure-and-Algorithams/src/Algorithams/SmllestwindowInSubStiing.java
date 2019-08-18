package Algorithams;

public class SmllestwindowInSubStiing {

	static final int no_of_char =256;
	public static void main(String[] args) 
		{ 
	        String str = "this is a test string"; 
	        String pat = "tist"; 
	      
	    System.out.print("Smallest window is :\n " + 
	                        findSubString(str, pat)); 
	    } 
		
		// Function to find smallest window containing 
	    // all characters of 'pat' 
	    static String findSubString(String str, String pat) 
	    { 
	    	int len1 = str.length();
	    	int len2 = pat.length();
	    	
	    	// check if string's length is less than pattern's 
	        // length. If yes then no such window can exist 
	        if (len1 < len2) 
	        { 
	            System.out.println("No such window exists"); 
	            return ""; 
	        } 

	        
	    	int count =0, start = 0, min_length = Integer.MAX_VALUE, start_index = -1;
	    	
	    	int[] hash_str = new int[no_of_char];
	    	int[] hash_ptr = new int[no_of_char];
	    	
	    	for(int i =0; i< len2 ;i++) {
	    		hash_ptr[pat.charAt(i)]++;
	    	}
	    	
	    	for(int j =0; j< len1 ;j++) {
	    		
	    		hash_str[str.charAt(j)]++;
	    		
	    		// If string's char matches with pattern's char 
	            // then increment count
	    		if(hash_ptr[str.charAt(j)] != 0 &&
	    				hash_ptr[str.charAt(j)] >= hash_str[str.charAt(j)]) {
	    			count++;
	    		}
	    		
	    		if(count == len2) {
	    			
	    			while(hash_str[str.charAt(start)] > hash_ptr[str.charAt(start)] ||
	    					hash_ptr[str.charAt(start)] == 0) {
	    				
	    				if(hash_str[str.charAt(start)] > hash_ptr[str.charAt(start)]) {
	    					hash_str[str.charAt(start)]--;
	    				}
	    				start++;
	    			}
	    			
	    			int len_min = j-start+1;
	    			if(min_length > len_min) {
	    				min_length = len_min;
	    				start_index = start; 
	    			}
	    			
	    		}
	    	}
	    	
	    	if(start_index == -1) {
	    		 System.out.println("No such window exists"); 
	    	        return ""; 
	    	}
	    	
	    	return str.substring(start_index, start_index+min_length);
	    	
	    }
}
