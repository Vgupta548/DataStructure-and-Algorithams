package DataStructure.string;

public class Permutation {
	public static void main(String[] args) {
		permutation("ABC");
	}
	
	public static void permutation(String s) {
		perm(s, 0);
		System.out.println("---");
		permute(s, 0, s.length()-1);
	}
	
	public static void perm(String str, int start) {
	
		if(str.length() == start) {
			System.out.println(str);
			return;
		}
		//[] arr = str.toCharArray();
		for(int i =start; i<str.length(); i++) {
			//System.out.println("-- "+str+" "+start+" "+i);
			str = swap(str, start, i);
			perm(str, start+1);
			str = swap(str, start, i);
			//System.out.println(str);
		}
	}
	
	private static void permute(String str, int l, int r) 
    { 
        if (l == r) 
            System.out.println(str); 
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
    } 

	
	
	 public static String swap(String a, int i, int j) 
	    { 
	        char temp; 
	        char[] charArray = a.toCharArray(); 
	        temp = charArray[i] ; 
	        charArray[i] = charArray[j]; 
	        charArray[j] = temp; 
	        return String.valueOf(charArray); 
	    }

}
