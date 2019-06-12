package ask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortArrayByMinFreq {
	public static void main(String[] args) {

		int[] arr = {1,2,3,1,2,3,1,4,2,5,2,1,4};
		System.out.println(Arrays.toString(arr));
		arr = SortByMinFreq1(arr)	;	
		System.out.println(Arrays.toString(arr));
	}
	
	private static int[] SortByMinFreq(int[] arr) {
		int res[] = new int[arr.length];
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			int count = map.getOrDefault(arr[i], 0);
			map.put(arr[i], count+1);
			list.add(arr[i]);
		}
		
		Collections.sort(list, new ListComparatorByMapValue(map));
		for(int i=0; i<arr.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	
	private static int[] SortByMinFreq1(int[] arr) {
		int res[] = new int[arr.length];
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			int count = map.getOrDefault(arr[i], 0);
			map.put(arr[i], count+1);
			list.add(arr[i]);
		}
		
		Map<Integer, Integer> treemap = new TreeMap<Integer, Integer>(new ListComparatorByMapValue(map));
		treemap.putAll(map);
		int j = 0;
			for(Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
				int key = entry.getKey();
				int freq = entry.getValue();
				for(int i=0; i<freq; i++) {
					res[j++] = key;
				}
			}
		return res;
	}

}


class ListComparatorByMapValue implements Comparator<Integer>{
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	ListComparatorByMapValue(Map<Integer, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		
		int mapFreq = map.get(o2).compareTo(map.get(o1));
		if(mapFreq == 0) {
			return o1.compareTo(o2);
		}
		return mapFreq;
	}

	
	
}