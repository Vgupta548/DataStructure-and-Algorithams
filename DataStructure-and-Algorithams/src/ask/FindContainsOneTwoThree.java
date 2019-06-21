package ask;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator; 

public class FindContainsOneTwoThree {

	// prints all the number containing 1, 2, 3  
    // in any order 
    private static String printNumbers(int[] numbers) 
    { 
          
        ArrayList<Integer> array = new ArrayList<>(); 
        for (int number : numbers) { 
              
            // check if the number contains 1,  
            // 2 & 3 in any order 
            if (findContainsOneTwoThree(number)) 
                array.add(number); 
        } 
  
        // sort all the numbers 
        Collections.sort(array); 
          
        StringBuffer strbuf = new StringBuffer(); 
        Iterator<Integer> it = array.iterator();         
        while (it.hasNext()) { 
              
            int value = (int)it.next(); 
            if (strbuf.length() > 0) 
                strbuf.append(", "); 
                  
            strbuf.append(Integer.toString(value)); 
        } 
          
        return (strbuf.length() > 0) ?  
                     strbuf.toString() : "-1"; 
    } 
  
    // convert the number to string and find  
    // if it contains 1, 2 & 3. 
    private static boolean findContainsOneTwoThree( 
                                         int number) 
    { 
          
        String str = Integer.toString(number);         
        return (str.contains("1") && str.contains("2") &&  
                                    str.contains("3")); 
    } 
  
    public static void main(String[] args)  
    {         
        int[] numbers = { 123, 1232, 456, 234, 32145 };         
        System.out.println(printNumbers(numbers)); 
    } 
} 