package DataStructure.matrix;

import java.util.ArrayList;

/*
 *Java ArrayList to print all possible words from phone digits
 *
 * { 1 }     { 2 }     { 3 }
[ABC]     [DEF]     [GHI]

{ 4 }     { 5 }    { 6 }
[JKL]     [MNO]    [PQR]

{ 7 }     { 8 }    { 9 }
[STU]     [VWX]    [YZ]

Input: str = "12" 
Output: [ad, bd, cd, ae, be, ce, af, bf, cf]

Input: str = "4"
Output: [j, k, l]

 * 
 * https://www.geeksforgeeks.org/java-arraylist-to-print-all-possible-words-from-phone-digits/
 */
public class Keypad_Print_All_Possible_Words {
	// String array to store keypad characters 
    static final String codes[]  = { " ", "abc", "def", 
						            "ghi", "jkl", "mno", 
						            "pqr", "stu", "vwx", 
						            "yz" }; 
    
    
    public static ArrayList<String> printKeyWords(String str){
    	if(str.length() == 0) {
    		ArrayList<String> base = new ArrayList<String>();
    		base.add("");
    		return base;
    	}
    	
    	char ch = str.charAt(0);
    	
    	String rem = str.substring(1);
    	
    	ArrayList<String> prevList = printKeyWords(rem);
    	
    	ArrayList<String> curr = new ArrayList<String>();
    	
    	String code = codes[ch-'0'];
    	
    	for(String value: prevList) {
    		for(int i=0; i<code.length(); i++) {
    			curr.add(code.charAt(i)+value);
    		}
    	}
    	
    	return curr;
    }
    
    public static void main(String[] args) 
    { 
        String str = "23"; 
  
        // Print all the possible words 
        System.out.println(printKeyWords(str)); 
    } 
}
