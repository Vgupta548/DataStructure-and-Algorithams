package ask;

public class TidyNum {

	public static void main(String[] args) {
		String str = "11333445538";
		int len = str.length();

		// num will store closest tidy number
		System.out.println(tidyNum(str, len));

	}

	static String tidyNum(String str1, int len) {

		char[] str = str1.toCharArray();
		for(int i = len -2; i>=0; i--) {
			if(str[i] > str[i+1]) {
				str[i]--;
				for(int j=i+1; j<len; j++) {
					str[j] = '9';
				}
			}
		}
		return String.valueOf(str);
	}

}
