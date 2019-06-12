package ask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * Company : Paramati
 * 
 * Sweets which has max no in laxical order
 * 
 * @author vipingupta
 *
 */
public  class Sweets  {
	
	public static void main(String[] args) {
		List<String> sweets = new ArrayList<String>();
		sweets.add("pada");
		sweets.add("laddu");
		sweets.add("gulab");
		sweets.add("pada");
		sweets.add("gulab");
		sweets.add("laddu");
		sweets.add("ras");
		
		System.out.println(resolve(sweets));
		
	}
	
	public static String resolve(List<String> sweets) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for(int i=0; i<sweets.size(); i++) {
			String sweet = sweets.get(i);
			
			if(map.containsKey(sweet)) {
				map.put(sweet, map.get(sweet)+1);
			}else {
				map.put(sweet, 1);
			}
		}
		
		
		List<String> list = new ArrayList<String>();
		int max = 0;
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() >= max) {
				list.add(entry.getKey());
				max = entry.getValue();
			}
		}
		
		StringJoiner j = new StringJoiner("-");
		for(String key : list) {
			j.add(key);
		}
		
		return j.toString();
	}
}





	
		
		

		

