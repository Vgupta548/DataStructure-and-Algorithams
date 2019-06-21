package DataStructure.string;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//Java program to Count number of ways we 
//can get palindrome string from a given string 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 

/**
 * 
 * Approach:
 *	1- We can have two types of palindrome strings that we need to handle -Even Length -Odd Length
 *  2- The idea is to consider a mid point and keep checking for the palindrome string
 * 		by comparing the elements on the left and the elements on the right by increasing the distance or palindromeRadius by one at a time 
 * 		until there is a mismatch.
 *  3- The algorithm handles the even and odd length palindrome scenarios in a single pass.
 *  4- The pivot starts from 0 and moves till the end with a step size of 0.5.
 *		…….a) when the pivot is a non-fractional value, then the palindromeRadius values are integral starting from 0.
 *  	…….b) when the pivot is a fractional value, then the palindromeRadius values are like 0.5, 1.5, 2.5, 3.5 ..
 *  5- So, each time we get a palindrome match, we put it in a list (so that the duplicate values are preserved 
 * 		because each duplicate sub-string is obtained by a different combination of alphabet positions)
 * 
 * @author vipingupta
 *
 */
public class AllPalindromeSubstringsPossible { 
 public static List<String> allPalindromeSubstring(String s) 
 { 
	 System.out.println("======================== String ======================= : "+s);
     List<String> list = new ArrayList<String>(); 
     Set<String> set = new HashSet(); 
     int n = s.length()-1;
    
     //moving the pivot from Starting till end of the string
     for(float pivot =0; pivot <= n; pivot += 0.5) {
    	 
    	 // set radius to the first nearest element on left and right
    	 float palindromeRadius = pivot - (int)pivot;
    	 
    	 //if the position needs to be compared has an element
    	 // and the characters at left and right matches
    	 while( (pivot + palindromeRadius <= n) &&
    			(pivot - palindromeRadius >= 0) &&
    			s.charAt((int) (pivot + palindromeRadius)) == 
    			s.charAt((int) (pivot - palindromeRadius))
    			){
    		 list.add(s.substring((int) (pivot - palindromeRadius), (int) (pivot + palindromeRadius)+1));
    		 set.add(s.substring((int) (pivot - palindromeRadius), (int) (pivot + palindromeRadius)+1));
    		 
    		 //increasing the radius by 1 to point the next elements in left and right
    		 palindromeRadius++;
    	 }
     }
     System.out.println("-----distinct----");
     System.out.println(set.size());
     System.out.println(set);
     System.out.println("-----all-----");
     return list; 
 } 
 
 public static List<String> allPalindromeSubstringForMoreThanOneLength(String s) 
 { 
	 System.out.println("======================== String ======================= : "+s);
     List<String> list = new ArrayList<String>(); 
     Set<String> set = new HashSet(); 
     int n = s.length()-1;
    
     boolean  isOdd = true;
     //moving the pivot from Starting till end of the string
     for(float pivot =0; pivot <= n; pivot += 0.5) {
    	 // set radius to the first nearest element on left and right
    	 float palindromeRadius = pivot - (int)pivot;
    	 palindromeRadius = isOdd ? palindromeRadius+1 : palindromeRadius;
    	 
    	 //if the position needs to be compared has an element
    	 // and the characters at left and right matches
    	 while( (pivot + palindromeRadius <= n) &&
    			(pivot - palindromeRadius >= 0) &&
    			s.charAt((int) (pivot + palindromeRadius)) == 
    			s.charAt((int) (pivot - palindromeRadius))
    			){
    		 list.add(s.substring((int) (pivot - palindromeRadius), (int) (pivot + palindromeRadius)+1));
    		 set.add(s.substring((int) (pivot - palindromeRadius), (int) (pivot + palindromeRadius)+1));
    		 
    		 //increasing the radius by 1 to point the next elements in left and right
    		 palindromeRadius++;
    	 }
    	 isOdd = !isOdd;
     }
     System.out.println("-----distinct----");
     System.out.println(set.size());
     System.out.println(set);
     System.out.println("-----all-----");
     return list; 
 } 

 // Drivers code 
 public static void main(String[] args) throws IOException 
 { 
	
     List<String> list = allPalindromeSubstring("legefgtayfuqntwwworaeafheoxyzrukwaqdijfipzbevxarottsvzzznwaopuynwothaaprasxxsa"); 
     System.out.println(list.size()); 
     System.out.println(list); 
     list = allPalindromeSubstringForMoreThanOneLength("legefgtayfuqntwwworaeafheoxyzrukwaqdijfipzbevxarottsvzzznwaopuynwothaaprasxxsa"); 
     System.out.println(list.size()); 
     System.out.println(list);
     
     list = allPalindromeSubstring("aaaaaa"); 
     System.out.println(list.size()); 
     System.out.println(list);
     list = allPalindromeSubstringForMoreThanOneLength("aaaaaa"); 
     System.out.println(list.size()); 
     System.out.println(list);
     
     list = allPalindromeSubstring("geek"); 
     System.out.println(list.size()); 
     System.out.println(list); 
     list = allPalindromeSubstringForMoreThanOneLength("geek"); 
     System.out.println(list.size()); 
     System.out.println(list);
     
     list = allPalindromeSubstring("abaaa"); 
     System.out.println(list.size()); 
     System.out.println(list); 
     list = allPalindromeSubstringForMoreThanOneLength("abaaa"); 
     System.out.println(list.size()); 
     System.out.println(list);
     
 } 
} 